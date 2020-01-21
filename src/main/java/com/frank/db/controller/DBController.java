package com.frank.db.controller;

import com.frank.db.service.FdHNWFormService;
import com.frank.db.utils.DBUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DBController {


    @Autowired
    DBUtils dbUtils;

    @Autowired
    private FdHNWFormService fdHNWFormService;

    @RequestMapping("/mssql")
    @ResponseBody
    public String factoryBean(long rowId) {
        return fdHNWFormService.selectByPrimaryKey(rowId).toString();
    }


    @RequestMapping("/sybaseRef")
    @ResponseBody
    public String sybaseRefTest() {

        try {
            String sql = "select * from aidcconfig..tuser_authority where system_type='DCM' and user_id='huabdns'";
            List<Map<String, Object>> maps = dbUtils.excuteSQL(dbUtils.SYBASE_DB_IWS_REF, sql);
            return maps.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/sybaseClaim")
    @ResponseBody
    public String sybaseClaimTest() {

        try {
            String sql = "select * from aidcconfig..tfunc_level where system_type = 'DCM'";
            List<Map<String, Object>> maps = dbUtils.excuteSQL(dbUtils.SYBASE_CLAIMS, sql);
            return maps.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
