package cn.gzyinyuan.yy.modules.sys.service.impl;

import cn.gzyinyuan.yy.common.exception.RRException;
import cn.gzyinyuan.yy.common.utils.Constant;
import cn.gzyinyuan.yy.modules.sys.dao.SysRoleDao;
import cn.gzyinyuan.yy.modules.sys.entity.SysRoleEntity;
import cn.gzyinyuan.yy.modules.sys.service.SysRoleMenuService;
import cn.gzyinyuan.yy.modules.sys.service.SysRoleService;
import cn.gzyinyuan.yy.modules.sys.service.SysUserRoleService;
import cn.gzyinyuan.yy.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 角色服务实现类
 * Created by DT人 on 2017/9/7 14:11.
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysUserService sysUserService;

    public SysRoleEntity queryObject(Long roleId) {
        return sysRoleDao.queryObject(roleId);
    }

    public List<SysRoleEntity> queryList(Map<String, Object> map) {
        return sysRoleDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return sysRoleDao.queryTotal(map);
    }

    @Transactional
    public void save(SysRoleEntity role) {
        role.setCreateTime(new Date());
        sysRoleDao.save(role);

        //检查权限是否越权
        checkPrems(role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Transactional
    public void update(SysRoleEntity role) {
        sysRoleDao.update(role);

        //检查权限是否越权
        checkPrems(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Transactional
    public void deleteBatch(Long[] roleIds) {
        sysRoleDao.deleteBatch(roleIds);
    }

    public List<Long> queryRoleIdList(Long createUserId) {
        return sysRoleDao.queryRoleIdList(createUserId);
    }

    /**
     * 检查权限是否越权
     */
    private void checkPrems(SysRoleEntity role){
        //如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
        if(role.getCreateUserId() == Constant.SUPER_ADMIN){
            return ;
        }

        //查询用户所拥有的菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());

        //判断是否越权
        if(!menuIdList.containsAll(role.getMenuIdList())){
            throw new RRException("新增角色的权限，已超出你的权限范围");
        }
    }
}
