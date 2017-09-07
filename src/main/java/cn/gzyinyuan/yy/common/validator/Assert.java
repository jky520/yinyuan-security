package cn.gzyinyuan.yy.common.validator;

import cn.gzyinyuan.yy.common.exception.RRException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 * Created by DT人 on 2017/9/7 10:47.
 */
public abstract class Assert {
    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }
}
