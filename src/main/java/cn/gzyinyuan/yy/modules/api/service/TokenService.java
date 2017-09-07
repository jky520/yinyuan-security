package cn.gzyinyuan.yy.modules.api.service;

import cn.gzyinyuan.yy.modules.api.entity.TokenEntity;

import java.util.Map;

/**
 * 用户Token
 * Created by DT人 on 2017/9/7 11:14.
 */
public interface TokenService {
    TokenEntity queryByUserId(Long userId);

    TokenEntity queryByToken(String token);

    void save(TokenEntity token);

    void update(TokenEntity token);

    /**
     * 生成token
     * @param userId  用户ID
     * @return        返回token相关信息
     */
    Map<String, Object> createToken(long userId);
}
