package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:10
 */
@Data
public class QueryNePerformanceIndexParam implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

//    {
//        "nfId":"",
//            "nfType":"",
//            "performanceIndexs":{
//        "indexCode":"",
//                "sliceId":"",
//                "dnnName":""
//    }
//    }

    /**
     * nfId
     */
    private String nfId;

    /**
     * nf类型
     */
    private String nfType;

    /**
     * 性能指标
     */
    private PerformanceIndexs performanceIndexs;
}
