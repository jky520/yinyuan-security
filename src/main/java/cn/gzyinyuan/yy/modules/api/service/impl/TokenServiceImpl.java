package cn.gzyinyuan.yy.modules.api.service.impl;

import cn.gzyinyuan.yy.modules.api.dao.TokenDao;
import cn.gzyinyuan.yy.modules.api.entity.TokenEntity;
import cn.gzyinyuan.yy.modules.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by DT人 on 2017/9/7 11:16.
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDao tokenDao;
    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    public TokenEntity queryByUserId(Long userId) {
        return tokenDao.queryByUserId(userId);
    }

    public TokenEntity queryByToken(String token) {
        return tokenDao.queryByToken(token);
    }

    public void save(TokenEntity token){
        tokenDao.save(token);
    }

    public void update(TokenEntity token){
        tokenDao.update(token);
    }

    public Map<String, Object> createToken(long userId) {
        //生成一个token
        String token = UUID.randomUUID().toString();
        //当前时间
        Date now = new Date();

        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        TokenEntity tokenEntity = queryByUserId(userId);
        if(tokenEntity == null){
            tokenEntity = new TokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            save(tokenEntity);
        }else{
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            update(tokenEntity);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", token);
        map.put("expire", EXPIRE);

        return map;
    }
}
