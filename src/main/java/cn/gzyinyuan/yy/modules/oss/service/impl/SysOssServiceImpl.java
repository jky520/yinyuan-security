package cn.gzyinyuan.yy.modules.oss.service.impl;

import cn.gzyinyuan.yy.modules.oss.dao.SysOssDao;
import cn.gzyinyuan.yy.modules.oss.entity.SysOssEntity;
import cn.gzyinyuan.yy.modules.oss.service.SysOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * Created by DT人 on 2017/9/7 15:35.
 */
@Service("sysOssService")
public class SysOssServiceImpl implements SysOssService {

    @Autowired
    private SysOssDao sysOssDao;

    public SysOssEntity queryObject(Long id){
        return sysOssDao.queryObject(id);
    }

    public List<SysOssEntity> queryList(Map<String, Object> map){
        return sysOssDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map){
        return sysOssDao.queryTotal(map);
    }

    public void save(SysOssEntity sysOss){
        sysOssDao.save(sysOss);
    }

    public void update(SysOssEntity sysOss){
        sysOssDao.update(sysOss);
    }

    public void delete(Long id){
        sysOssDao.delete(id);
    }

    public void deleteBatch(Long[] ids){
        sysOssDao.deleteBatch(ids);
    }
}
