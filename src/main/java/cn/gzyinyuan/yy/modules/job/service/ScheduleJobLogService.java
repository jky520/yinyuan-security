package cn.gzyinyuan.yy.modules.job.service;

import cn.gzyinyuan.yy.modules.job.entity.ScheduleJobLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 定时任务日志
 * Created by DT人 on 2017/9/7 15:59.
 */
public interface ScheduleJobLogService {

    /**
     * 根据ID，查询定时任务日志
     */
    ScheduleJobLogEntity queryObject(Long jobId);

    /**
     * 查询定时任务日志列表
     */
    List<ScheduleJobLogEntity> queryList(Map<String, Object> map);

    /**
     * 查询总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存定时任务日志
     */
    void save(ScheduleJobLogEntity log);
}
