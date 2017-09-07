package cn.gzyinyuan.yy.modules.api.dao;

import cn.gzyinyuan.yy.modules.api.entity.TokenEntity;
import cn.gzyinyuan.yy.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Token
 * Created by DT人 on 2017/9/7 14:44.
 */
@Mapper
public interface TokenDao extends BaseDao<TokenEntity> {

    TokenEntity queryByUserId(Long userId);

    TokenEntity queryByToken(String token);
}
