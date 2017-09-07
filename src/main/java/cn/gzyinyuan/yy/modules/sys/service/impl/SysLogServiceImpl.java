package cn.gzyinyuan.yy.modules.sys.service.impl;

import cn.gzyinyuan.yy.modules.sys.dao.SysLogDao;
import cn.gzyinyuan.yy.modules.sys.entity.SysLogEntity;
import cn.gzyinyuan.yy.modules.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 日志的服务实现类
 * Created by DT人 on 2017/9/7 14:04.
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    public SysLogEntity queryObject(Long id){
        return sysLogDao.queryObject(id);
    }

    public List<SysLogEntity> queryList(Map<String, Object> map){
        return sysLogDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map){
        return sysLogDao.queryTotal(map);
    }

    public void save(SysLogEntity sysLog){
        sysLogDao.save(sysLog);
    }

    public void update(SysLogEntity sysLog){
        sysLogDao.update(sysLog);
    }

    public void delete(Long id){
        sysLogDao.delete(id);
    }

    public void deleteBatch(Long[] ids){
        sysLogDao.deleteBatch(ids);
    }

}
