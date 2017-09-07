package cn.gzyinyuan.yy.modules.api.annotation;

import java.lang.annotation.*;

/**
 * api接口，忽略Token验证
 * Created by DT人 on 2017/9/7 11:07.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthIgnore {
}
