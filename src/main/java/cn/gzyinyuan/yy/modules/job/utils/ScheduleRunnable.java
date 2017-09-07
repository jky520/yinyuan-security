package cn.gzyinyuan.yy.modules.job.utils;

import cn.gzyinyuan.yy.common.exception.RRException;
import cn.gzyinyuan.yy.common.utils.SpringContextUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * 执行定时任务
 * Created by DT人 on 2017/9/7 16:38.
 */
public class ScheduleRunnable implements Runnable {

    private Object target;
    private Method method;
    private String params;

    public ScheduleRunnable(String beanName, String methodName, String params) throws NoSuchMethodException, SecurityException {
        this.target = SpringContextUtils.getBean(beanName);
        this.params = params;

        if(StringUtils.isNotBlank(params)){
            this.method = target.getClass().getDeclaredMethod(methodName, String.class);
        }else{
            this.method = target.getClass().getDeclaredMethod(methodName);
        }
    }

    public void run() {
        try {
            ReflectionUtils.makeAccessible(method);
            if(StringUtils.isNotBlank(params)){
                method.invoke(target, params);
            }else{
                method.invoke(target);
            }
        }catch (Exception e) {
            throw new RRException("执行定时任务失败", e);
        }
    }
}
