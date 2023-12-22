package com.jlstest.entitytodtoDemo.mapper;

import com.jlstest.entitytodtoDemo.dto.CcTasklogDTO;
import com.jlstest.entitytodtoDemo.entity.CcTasklogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author JLS
 * @description:
 * @since 2023-11-17 17:08
 */
@Mapper
public interface CcTasklogMapper {

//    private Integer id;
//    private String serviceName;
//    private String taskName;
//    private String moduleName;
//    private String startTime;
//    private String endTime;
//    private String state;
//    private String failContent;
//    private String remark;
    CcTasklogMapper INSTANCE = Mappers.getMapper(CcTasklogMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "serviceName", target = "serviceName")
    @Mapping(source = "taskName", target = "taskName")
    @Mapping(source = "moduleName", target = "moduleName")
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "endTime", target = "endTime")
    @Mapping(source = "state", target = "state")
    @Mapping(source = "failContent", target = "failContent")
    @Mapping(source = "remark", target = "remark")
    CcTasklogDTO ccTasklogEntityToDTO(CcTasklogEntity ccTasklogEntity);
}
