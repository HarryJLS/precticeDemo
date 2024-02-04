package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 19:59
 */
@Data
public class CoreNetworkFunctionParam implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

//    {
//        "dnnName":"",
//            "sliceId":"",
//            "deviceName":"",
//            "nfType":"",
//            "PageReq":{
//        "pageSize":1,
//                "pageNum":10,
//                "orders":""
//    },
//        "OrderItem":{
//        "column":"",
//                "asc":true
//    }
//    }

    /**
     * dnn名称
     */
    private String dnnName;

    /**
     * sliceId
     */
    private String sliceId;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * nf类型
     */
    private String nfType;

    /**
     * 分页参数
     */
    private PageReq PageReq;

    /**
     * 排序参数
     */
    private OrderItem OrderItem;
}
