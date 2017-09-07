package cn.gzyinyuan.yy.modules.api.service;

import cn.gzyinyuan.yy.modules.api.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * Created by DT人 on 2017/9/7 11:15.
 */
public interface UserService {

    UserEntity queryObject(Long userId);

    List<UserEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(String mobile, String password);

    void update(UserEntity user);

    void delete(Long userId);

    void deleteBatch(Long[] userIds);

    UserEntity queryByMobile(String mobile);

    /**
     * 用户登录
     * @param mobile    手机号
     * @param password  密码
     * @return          返回用户ID
     */
    long login(String mobile, String password);
}
