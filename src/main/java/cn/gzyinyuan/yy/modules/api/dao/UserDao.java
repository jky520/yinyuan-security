package cn.gzyinyuan.yy.modules.api.dao;

import cn.gzyinyuan.yy.modules.api.entity.UserEntity;
import cn.gzyinyuan.yy.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * Created by DT人 on 2017/9/7 14:46.
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity queryByMobile(String mobile);

}
