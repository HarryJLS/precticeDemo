package com.roy.shardingDemo.geneDemo;

/**
 * @author roy
 * @desc 基因法 分片示例
 * 插入数据时，可以根据用户名进行分片。查询数据时，按照用户名和用户ID都能快速查找到对应的分片。
 */
public class geneDemo {
    //二进制基因片段的长度
    public static final int datasize = 3;

    public static void main(String[] args) {
        //原始预备生成的用户名
        String username = "testroy";
        System.out.println("原始预备插入的用户名："+username);
        //原始预备生成的唯一ID
        long originId = 12394846L;
        System.out.println("原始预备插入的用户ID："+originId);

        int mask = (int)(Math.pow(2,datasize) -1);//掩码，二进制表述为全部是1.  111
        //根据用户名查询时，获取到的分片结果：
        System.out.println("根据用户名获取到的分片结果："+(username.hashCode() & mask));
        //给ID添加用户名的基因片段后的新ID  -- 将username.hashCode二进制的后三位替换成用户名的分片结果。  这样无法保证ID的唯一性。

//        long newId = originId - (originId & mask) + (username.hashCode() & mask);
//        System.out.println("添加分片基因后的用户ID："+newId);
//        //新生成的ID与用户名的分片结果保持一致，这样就能同时支持username和id都作为分片键。
//        System.out.println("根据用户ID获取到的分片结果："+(newId & mask));

        //给ID添加用户名的基因片段后的新ID  -- 将username.hashCode二进制左移三位，再添加用户名的分片结果。 这样保持了原始ID的唯一性。
        long newId2 = (originId<<datasize)|(username.hashCode() & mask);
        System.out.println("添加分片基因后的用户ID2："+newId2);
        System.out.println("根据用户ID2获取到的分片结果："+(newId2 & mask));
    }
}

