package cn.gzyinyuan.yy.modules.job.dao;

import cn.gzyinyuan.yy.modules.job.entity.ScheduleJobEntity;
import cn.gzyinyuan.yy.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 定时任务
 * Created by DT人 on 2017/9/7 15:57.
 */
@Mapper
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
    /**
     * 批量更新状态
     */
    int updateBatch(Map<String, Object> map);
}
