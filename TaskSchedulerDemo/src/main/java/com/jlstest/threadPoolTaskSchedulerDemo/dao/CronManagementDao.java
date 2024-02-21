package com.jlstest.threadPoolTaskSchedulerDemo.dao;

import com.jlstest.threadPoolTaskSchedulerDemo.entity.CronEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-02-19 14:41
 */
@Mapper
public interface CronManagementDao {

    /**
     * 新增定时任务
     */
    void insertCronManagement(CronEntity cronEntity);

    /**
     * 修改定时任务
     */
    int updateCronManagement(CronEntity cronEntity);

    /**
     * 删除定时任务
     */
    int deleteCronManagement(Long id);

    /**
     * 查询定时任务
     */
    CronEntity selectCronManagement(Long id);

    /**
     * 查询所有定时任务
     */
    List<CronEntity> selectCronManagementAll();

}
