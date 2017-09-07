package cn.gzyinyuan.yy.modules.sys.service;

import cn.gzyinyuan.yy.common.utils.R;
import cn.gzyinyuan.yy.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 * Created by DT人 on 2017/9/7 14:01.
 */
public interface SysUserTokenService {

    SysUserTokenEntity queryByUserId(Long userId);

    SysUserTokenEntity queryByToken(String token);

    void save(SysUserTokenEntity token);

    void update(SysUserTokenEntity token);

    /**
     * 生成token
     * @param userId  用户ID
     */
    R createToken(long userId);
}
