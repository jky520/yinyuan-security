package cn.gzyinyuan.yy.modules.sys.dao;

import cn.gzyinyuan.yy.modules.sys.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户与角色对应关系
 * Created by DT人 on 2017/9/7 11:37.
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {
    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);
}
