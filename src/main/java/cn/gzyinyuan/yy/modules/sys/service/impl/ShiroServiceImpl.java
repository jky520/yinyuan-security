package cn.gzyinyuan.yy.modules.sys.service.impl;

import cn.gzyinyuan.yy.common.utils.Constant;
import cn.gzyinyuan.yy.modules.sys.dao.SysMenuDao;
import cn.gzyinyuan.yy.modules.sys.dao.SysUserDao;
import cn.gzyinyuan.yy.modules.sys.dao.SysUserTokenDao;
import cn.gzyinyuan.yy.modules.sys.entity.SysMenuEntity;
import cn.gzyinyuan.yy.modules.sys.entity.SysUserEntity;
import cn.gzyinyuan.yy.modules.sys.entity.SysUserTokenEntity;
import cn.gzyinyuan.yy.modules.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * shiro的实现类
 * Created by DT人 on 2017/9/7 11:41.
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuDao sysMenuDao; // @Mapper不能自动注入,在出红线的地方 alt+enter，选第一个 有个editXXX，或Settings->Editor->Color Scheme->Inspections
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserTokenDao sysUserTokenDao;

    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            List<SysMenuEntity> menuList = sysMenuDao.queryList(new HashMap<String, Object>());
            permsList = new ArrayList<String>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    public SysUserTokenEntity queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    public SysUserEntity queryUser(Long userId) {
        return sysUserDao.queryObject(userId);
    }
}
