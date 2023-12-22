package com.jlstest.entitytodtoDemo;

import com.jlstest.entitytodtoDemo.dto.CcTasklogDTO;
import com.jlstest.entitytodtoDemo.entity.CcTasklogEntity;
import com.jlstest.entitytodtoDemo.mapper.CcTasklogMapper;


/**
 * @author JLS
 * @description:
 * @since 2023-11-17 17:11
 */
public class TestMain {


    public static void main(String[] args) {
        CcTasklogEntity ccTasklogEntity = new CcTasklogEntity();
        ccTasklogEntity.setId(1);
        ccTasklogEntity.setServiceName("serviceName");
        ccTasklogEntity.setTaskName("taskName");
        ccTasklogEntity.setModuleName("moduleName");
        ccTasklogEntity.setStartTime("startTime");
        ccTasklogEntity.setEndTime("endTime");
        ccTasklogEntity.setState("state");
        ccTasklogEntity.setFailContent("failContent");
        ccTasklogEntity.setRemark("remark");

        CcTasklogDTO ccTasklogDTO = CcTasklogMapper.INSTANCE.ccTasklogEntityToDTO(ccTasklogEntity);
        System.out.println(ccTasklogDTO.toString());
    }
}

