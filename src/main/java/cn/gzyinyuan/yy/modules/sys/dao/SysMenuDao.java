package cn.gzyinyuan.yy.modules.sys.dao;

import cn.gzyinyuan.yy.modules.sys.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单管理
 * Created by DT人 on 2017/9/7 11:34.
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();

    /**
     * 查询用户的权限列表
     */
    List<SysMenuEntity> queryUserList(Long userId);
}
