package cn.gzyinyuan.yy.modules.sys.service.impl;

import cn.gzyinyuan.yy.common.utils.Constant;
import cn.gzyinyuan.yy.modules.sys.dao.SysMenuDao;
import cn.gzyinyuan.yy.modules.sys.entity.SysMenuEntity;
import cn.gzyinyuan.yy.modules.sys.service.SysMenuService;
import cn.gzyinyuan.yy.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 菜单服务实现类
 * Created by DT人 on 2017/9/7 14:06.
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserService sysUserService;

    public List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenuEntity> menuList = queryListParentId(parentId);
        if(menuIdList == null){
            return menuList;
        }

        List<SysMenuEntity> userMenuList = new ArrayList<SysMenuEntity>();
        for(SysMenuEntity menu : menuList){
            if(menuIdList.contains(menu.getMenuId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    public List<SysMenuEntity> queryListParentId(Long parentId) {
        return sysMenuDao.queryListParentId(parentId);
    }

    public List<SysMenuEntity> queryNotButtonList() {
        return sysMenuDao.queryNotButtonList();
    }

    public List<SysMenuEntity> getUserMenuList(Long userId) {
        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            return getAllMenuList(null);
        }

        //用户菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }

    public SysMenuEntity queryObject(Long menuId) {
        return sysMenuDao.queryObject(menuId);
    }

    public List<SysMenuEntity> queryList(Map<String, Object> map) {
        return sysMenuDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return sysMenuDao.queryTotal(map);
    }

    public void save(SysMenuEntity menu) {
        sysMenuDao.save(menu);
    }

    public void update(SysMenuEntity menu) {
        sysMenuDao.update(menu);
    }

    @Transactional
    public void deleteBatch(Long[] menuIds) {
        sysMenuDao.deleteBatch(menuIds);
    }

    public List<SysMenuEntity> queryUserList(Long userId) {
        return sysMenuDao.queryUserList(userId);
    }

    /**
     * 获取所有菜单列表
     */
    private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList){
        //查询根菜单列表
        List<SysMenuEntity> menuList = queryListParentId(0L, menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }

    /**
     * 递归
     */
    private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Long> menuIdList){
        List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();

        for(SysMenuEntity entity : menuList){
            if(entity.getType() == Constant.MenuType.CATALOG.getValue()){//目录
                entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }
}
