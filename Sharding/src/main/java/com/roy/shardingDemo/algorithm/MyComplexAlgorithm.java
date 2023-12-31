package com.roy.shardingDemo.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.sharding.exception.syntax.UnsupportedShardingOperationException;

import java.util.*;

/**
 * 实现自定义COMPLEX分片策略
 * 声明算法时，ComplexKeysShardingAlgorithm接口可传入一个泛型，这个泛型就是分片键的数据类型。
 * 这个泛型只要实现了Comparable接口即可。
 * 但是官方不建议声明一个明确的泛型出来，建议是在doSharding中再做类型转换。这样是为了防止分片键类型与算法声明的类型不符合。
 * @auth roykingw
 */
public class MyComplexAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    private static final String SHARING_COLUMNS_KEY = "sharding-columns";

    private Properties props;
    //保留配置的分片键。在当前算法中其实是没有用的。
    private Collection<String> shardingColumns;

    @Override
    public void init(Properties props) {
        this.props = props;
        this.shardingColumns = getShardingColumns(props);
    }

    /**
     * 实现自定义分片算法
     * @param availableTargetNames 在actual-nodes中配置了的所有数据分片
     * @param shardingValue 组合分片键
     * @return 目标分片
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<Long> shardingValue) {
        //select * from cid where cid in (xxx,xxx,xxx) and user_id between {lowerEndpoint} and {upperEndpoint};
        Collection<Long> cidCol = shardingValue.getColumnNameAndShardingValuesMap().get("cid");
        Range<Long> userIdRange = shardingValue.getColumnNameAndRangeValuesMap().get("user_id");
        //拿到user_id的查询范围
        Long lowerEndpoint = userIdRange.lowerEndpoint();
        Long upperEndpoint = userIdRange.upperEndpoint();
        //如果下限 》= 上限
        if(lowerEndpoint >= upperEndpoint){
            //抛出异常，终止去数据库查询的操作
            throw new UnsupportedShardingOperationException("empty record query","course");
            //如果查询范围明显不包含1001
        }else if(upperEndpoint<1001L || lowerEndpoint>1001L){
            //抛出异常，终止去数据库查询的操作
            throw new UnsupportedShardingOperationException("error range query param","course");
//            return result;
        }else{
            List<String> result = new ArrayList<>();
            //user_id范围包含了1001后，就按照cid的奇偶分片
            String logicTableName = shardingValue.getLogicTableName();//操作的逻辑表 course
            for (Long cidVal : cidCol) {
                String targetTable = logicTableName+"_"+(cidVal%2+1);
                if(availableTargetNames.contains(targetTable)){
                    result.add(targetTable);
                }
            }
            return result;
        }
    }

    private Collection<String> getShardingColumns(final Properties props) {
        String shardingColumns = props.getProperty(SHARING_COLUMNS_KEY, "");
        return shardingColumns.isEmpty() ? Collections.emptyList() : Arrays.asList(shardingColumns.split(","));
    }

    public void setProps(Properties props) {
        this.props = props;
    }
    @Override
    public Properties getProps() {
        return this.props;
    }
    @Override
    public String getType(){
        return "MYCOMPLEX";
    }
}
