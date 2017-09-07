package cn.gzyinyuan.yy.modules.sys.controller;

import cn.gzyinyuan.yy.common.utils.PageUtils;
import cn.gzyinyuan.yy.common.utils.Query;
import cn.gzyinyuan.yy.common.utils.R;
import cn.gzyinyuan.yy.modules.sys.entity.SysLogEntity;
import cn.gzyinyuan.yy.modules.sys.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 * Created by DT人 on 2017/9/7 14:33.
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("sys:log:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<SysLogEntity> sysLogList = sysLogService.queryList(query);
        int total = sysLogService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(sysLogList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }
}
