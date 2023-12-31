package com.roy.shardingDemo;

/**
 * @auth roykingw
 */
public class SnowFlakeTest {

    public static void main(String[] args) {
        //如果ID是连续的，那么数据能够很平均的分到两个库的两个片里。
//        for (long i = 0; i < 100; i++) {
//            long database = i % 2;
//            long table = ((i + 1) % 4) / 2 + 1;
//            System.out.println("主键："+i+";库分片："+database +":表分片"+table);
//        }

//        //换成雪花算法生成的一系列结果，就只能按奇偶分到两个片了。
        int mask = (1<<12)-1;
//        //原始的雪花算法生成的一部分主键
//        long[] snowflakeids = new long[]{856196766096162817L,856196766150688769L,856196766201020417L,856196766247157761L,856196766293295105L,
//                856198044213837825L,856198044272558081L,856198044322889729L,856198044373221377L,856198044415164417L,
//                856196764816900096L,856196766125522944L,856196766171660288L,856196766226186240L,856196766272323584L,
//                856198042867466240L,856198044247392256L,856198044301918208L,856198044348055552L,856198044394192896L};

//        //修改后的雪花算法，序列号位是严格递增的，所有正常分到四个分片。
        long[] snowflakeids = new long[]{856198551309385732L,856198551401660424L,
                856198550021734401L,856198551330357253L,856198551422631945L,
                856198551254859778L,856198551355523078L,856198551451992074L,
                856198551280025603L,856198551380688903L};

        for (long snowflakeid : snowflakeids) {
            long database = snowflakeid % 2;
//            long table = ((snowflakeid + 1) % 4) / 2 + 1;
            long table = snowflakeid % 8;
            System.out.println("主键："+snowflakeid+";库分片："+database +":表分片"+table);
            System.out.println("雪花算法主键："+snowflakeid+" 的序列号位为："+(snowflakeid & mask));
        }
    }
}
