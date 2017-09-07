package cn.gzyinyuan.yy.modules.sys.service;

import cn.gzyinyuan.yy.modules.sys.entity.SysUserEntity;
import cn.gzyinyuan.yy.modules.sys.entity.SysUserTokenEntity;

import java.util.Set;

/**
 * shiro相关接口
 * Created by DT人 on 2017/9/7 11:40.
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    SysUserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUserEntity queryUser(Long userId);
}
