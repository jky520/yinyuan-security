package cn.gzyinyuan.yy.modules.oss.cloud;

import cn.gzyinyuan.yy.common.exception.RRException;
import com.aliyun.oss.OSSClient;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by DT人 on 2017/9/7 15:40.
 */
public class AliyunCloudStorageService extends CloudStorageService {

    private OSSClient client;

    public AliyunCloudStorageService(CloudStorageConfig config){
        this.config = config;

        //初始化
        init();
    }

    private void init(){
        client = new OSSClient(config.getAliyunEndPoint(), config.getAliyunAccessKeyId(),
                config.getAliyunAccessKeySecret());
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    public String upload(InputStream inputStream, String path) {
        try {
            client.putObject(config.getAliyunBucketName(), path, inputStream);
        } catch (Exception e){
            throw new RRException("上传文件失败，请检查配置信息", e);
        }

        return config.getAliyunDomain() + "/" + path;
    }

    @Override
    public String upload(byte[] data) {
        return upload(data, getPath(config.getAliyunPrefix()));
    }

    public String upload(InputStream inputStream) {
        return upload(inputStream, getPath(config.getAliyunPrefix()));
    }
}
