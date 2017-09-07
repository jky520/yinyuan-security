package cn.gzyinyuan.yy.modules.sys.dao;

import cn.gzyinyuan.yy.modules.sys.entity.SysConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 系统配置信息
 * Created by DT人 on 2017/9/7 11:32.
 */
@Mapper
public interface SysConfigDao extends BaseDao<SysConfigEntity> {
    /**
     * 根据key，查询value
     */
    String queryByKey(String paramKey);

    /**
     * 根据key，更新value
     */
    int updateValueByKey(@Param("key") String key, @Param("value") String value);
}
