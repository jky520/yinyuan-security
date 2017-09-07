package cn.gzyinyuan.yy.modules.sys.service.impl;

import cn.gzyinyuan.yy.modules.sys.dao.SysUserRoleDao;
import cn.gzyinyuan.yy.modules.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 * Created by DT人 on 2017/9/7 14:13.
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        if(roleIdList.size() == 0){
            return ;
        }

        //先删除用户与角色关系
        sysUserRoleDao.delete(userId);

        //保存用户与角色关系
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("roleIdList", roleIdList);
        sysUserRoleDao.save(map);
    }

    public List<Long> queryRoleIdList(Long userId) {
        return sysUserRoleDao.queryRoleIdList(userId);
    }

    public void delete(Long userId) {
        sysUserRoleDao.delete(userId);
    }
}
