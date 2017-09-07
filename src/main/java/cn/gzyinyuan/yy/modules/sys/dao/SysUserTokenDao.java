package cn.gzyinyuan.yy.modules.sys.dao;

import cn.gzyinyuan.yy.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 * Created by DT人 on 2017/9/7 11:39.
 */
@Mapper
public interface SysUserTokenDao extends BaseDao<SysUserTokenEntity> {

    SysUserTokenEntity queryByUserId(Long userId);

    SysUserTokenEntity queryByToken(String token);
}
