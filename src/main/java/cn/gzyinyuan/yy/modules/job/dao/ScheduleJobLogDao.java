package cn.gzyinyuan.yy.modules.job.dao;

import cn.gzyinyuan.yy.modules.job.entity.ScheduleJobLogEntity;
import cn.gzyinyuan.yy.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 * Created by DT人 on 2017/9/7 15:59.
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
}
