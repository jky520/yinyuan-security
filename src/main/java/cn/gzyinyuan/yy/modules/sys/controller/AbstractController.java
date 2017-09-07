package cn.gzyinyuan.yy.modules.sys.controller;

import cn.gzyinyuan.yy.modules.sys.entity.SysUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;

/**
 * Controller公共组件
 * Created by DT人 on 2017/9/7 14:27.
 */
@Slf4j
public abstract class AbstractController {

    // protected Logger log = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser() {
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }
}
