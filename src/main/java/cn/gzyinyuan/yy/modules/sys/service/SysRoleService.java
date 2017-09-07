package cn.gzyinyuan.yy.modules.sys.service;

import cn.gzyinyuan.yy.modules.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色
 * Created by DT人 on 2017/9/7 13:59.
 */
public interface SysRoleService {

    SysRoleEntity queryObject(Long roleId);

    List<SysRoleEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(SysRoleEntity role);

    void update(SysRoleEntity role);

    void deleteBatch(Long[] roleIds);

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
}
