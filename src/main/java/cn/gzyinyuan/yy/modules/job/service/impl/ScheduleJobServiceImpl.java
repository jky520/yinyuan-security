package cn.gzyinyuan.yy.modules.job.service.impl;

import cn.gzyinyuan.yy.common.utils.Constant;
import cn.gzyinyuan.yy.modules.job.dao.ScheduleJobDao;
import cn.gzyinyuan.yy.modules.job.entity.ScheduleJobEntity;
import cn.gzyinyuan.yy.modules.job.service.ScheduleJobService;
import cn.gzyinyuan.yy.modules.job.utils.ScheduleUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DT人 on 2017/9/7 16:31.
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl implements ScheduleJobService {

    @Autowired
    private Scheduler scheduler;
    @Autowired
    private ScheduleJobDao schedulerJobDao;

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init(){
        List<ScheduleJobEntity> scheduleJobList = schedulerJobDao.queryList(new HashMap<String, Object>());
        for(ScheduleJobEntity scheduleJob : scheduleJobList){
            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobId());
            //如果不存在，则创建
            if(cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
            }else {
                ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
            }
        }
    }

    public ScheduleJobEntity queryObject(Long jobId) {
        return schedulerJobDao.queryObject(jobId);
    }

    public List<ScheduleJobEntity> queryList(Map<String, Object> map) {
        return schedulerJobDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return schedulerJobDao.queryTotal(map);
    }

    @Transactional
    public void save(ScheduleJobEntity scheduleJob) {
        scheduleJob.setCreateTime(new Date());
        scheduleJob.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
        schedulerJobDao.save(scheduleJob);

        ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
    }

    @Transactional
    public void update(ScheduleJobEntity scheduleJob) {
        ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);

        schedulerJobDao.update(scheduleJob);
    }

    @Transactional
    public void deleteBatch(Long[] jobIds) {
        for(Long jobId : jobIds){
            ScheduleUtils.deleteScheduleJob(scheduler, jobId);
        }

        //删除数据
        schedulerJobDao.deleteBatch(jobIds);
    }

    public int updateBatch(Long[] jobIds, int status){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", jobIds);
        map.put("status", status);
        return schedulerJobDao.updateBatch(map);
    }

    @Transactional
    public void run(Long[] jobIds) {
        for(Long jobId : jobIds){
            ScheduleUtils.run(scheduler, queryObject(jobId));
        }
    }

    @Transactional
    public void pause(Long[] jobIds) {
        for(Long jobId : jobIds){
            ScheduleUtils.pauseJob(scheduler, jobId);
        }

        updateBatch(jobIds, Constant.ScheduleStatus.PAUSE.getValue());
    }

    @Transactional
    public void resume(Long[] jobIds) {
        for(Long jobId : jobIds){
            ScheduleUtils.resumeJob(scheduler, jobId);
        }

        updateBatch(jobIds, Constant.ScheduleStatus.NORMAL.getValue());
    }
}
