package com.jlstest.sysJobDemo.dao;

import com.jlstest.sysJobDemo.entity.SysJob;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-02-18 15:32
 */
@Mapper
public interface SysJobMapper {

    List<SysJob> selectJobAll();

    List<SysJob> selectJobList(SysJob job);

    SysJob selectJobById(Long jobId);

    int updateJob(SysJob job);

    int deleteJobById(Long jobId);

    int insertJob(SysJob job);

}
