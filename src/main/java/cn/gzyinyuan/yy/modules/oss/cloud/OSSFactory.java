package cn.gzyinyuan.yy.modules.oss.cloud;

import cn.gzyinyuan.yy.common.utils.ConfigConstant;
import cn.gzyinyuan.yy.common.utils.Constant;
import cn.gzyinyuan.yy.common.utils.SpringContextUtils;
import cn.gzyinyuan.yy.modules.sys.service.SysConfigService;

/**
 * 文件上传Factory
 * Created by DT人 on 2017/9/7 15:43.
 */
public final class OSSFactory {

    private static SysConfigService sysConfigService;

    static {
        OSSFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }

    public static CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }

        return null;
    }
}
