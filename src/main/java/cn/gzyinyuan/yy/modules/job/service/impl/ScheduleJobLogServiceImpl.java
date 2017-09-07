package cn.gzyinyuan.yy.modules.job.service.impl;

import cn.gzyinyuan.yy.modules.job.dao.ScheduleJobLogDao;
import cn.gzyinyuan.yy.modules.job.entity.ScheduleJobLogEntity;
import cn.gzyinyuan.yy.modules.job.service.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by DT人 on 2017/9/7 16:04.
 */
@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {

    @Autowired
    private ScheduleJobLogDao scheduleJobLogDao;

    public ScheduleJobLogEntity queryObject(Long jobId) {
        return scheduleJobLogDao.queryObject(jobId);
    }

    public List<ScheduleJobLogEntity> queryList(Map<String, Object> map) {
        return scheduleJobLogDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return scheduleJobLogDao.queryTotal(map);
    }

    public void save(ScheduleJobLogEntity log) {
        scheduleJobLogDao.save(log);
    }
}
