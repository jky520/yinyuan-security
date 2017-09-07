package cn.gzyinyuan.yy.modules.sys.service;

import java.util.List;

/**
 * 用户与角色对应关系
 * Created by DT人 on 2017/9/7 14:00.
 */
public interface SysUserRoleService {

    void saveOrUpdate(Long userId, List<Long> roleIdList);

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);

    void delete(Long userId);
}
