package cn.gzyinyuan.yy.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * Created by DT人 on 2017/9/7 10:22.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
