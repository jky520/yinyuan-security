package cn.gzyinyuan.yy.modules.job.task;

import cn.gzyinyuan.yy.modules.sys.entity.SysUserEntity;
import cn.gzyinyuan.yy.modules.sys.service.SysUserService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务(演示Demo，可删除)
 * Created by DT人 on 2017/9/7 16:42.
 */
@Component("testTask")
public class TestTask {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserService sysUserService;

    public void test(String params){
        logger.info("我是带参数的test方法，正在被执行，参数为：" + params);

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SysUserEntity user = sysUserService.queryObject(1L);
        System.out.println(ToStringBuilder.reflectionToString(user));

    }


    public void test2(){
        logger.info("我是不带参数的test2方法，正在被执行");
    }
}
