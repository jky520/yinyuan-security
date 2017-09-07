package cn.gzyinyuan.yy.modules.sys.service;

import cn.gzyinyuan.yy.modules.sys.entity.SysLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 * Created by DT人 on 2017/9/7 13:57.
 */
public interface SysLogService {
    SysLogEntity queryObject(Long id);

    List<SysLogEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(SysLogEntity sysLog);

    void update(SysLogEntity sysLog);

    void delete(Long id);

    void deleteBatch(Long[] ids);
}
