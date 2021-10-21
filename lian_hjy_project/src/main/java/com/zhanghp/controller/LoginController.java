package com.zhanghp.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.zhanghp.bean.TblRole;
import com.zhanghp.bean.TblUserRecord;
import com.zhanghp.mapper.TblRoleMapper;
import com.zhanghp.returnJson.Permission;
import com.zhanghp.returnJson.Permissions;
import com.zhanghp.returnJson.ReturnObject;
import com.zhanghp.returnJson.UserInfo;
import com.zhanghp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    //登录调试
    @RequestMapping("/auth/login")
    public JSONObject Login01(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) {
        System.out.println("------------auth_login------------------");
        //密码加密打印
        //System.out.println(password);
        TblUserRecord tblUserRecord = loginService.login(username, password);

        tblUserRecord.setToken(tblUserRecord.getUserName());

        httpSession.setAttribute("userRecord",tblUserRecord);

        ReturnObject returnObject = new ReturnObject(tblUserRecord);
        //return JSONObject.parseObject(JSONObject.toJSONString(returnObject));
        return JSONObject.parseObject(JSONObject.toJSONString(returnObject));
    }


    //回显的功能模块
    @RequestMapping("/users/info")
    public JSONObject info(HttpSession httpSession){
        TblUserRecord tblUserRecord = (TblUserRecord)httpSession.getAttribute("userRecord");
        //System.out.println(tblUserRecord);
        //获取权限集合
        String[] split = tblUserRecord.getTblRole().getRolePrivileges().split("-");
        List<Permission> lp = new ArrayList<>();
        for (String s : split) {
            lp.add(new Permission(s));
        }
        Permissions permissions = new Permissions(lp);
        UserInfo userInfo = new UserInfo(tblUserRecord.getUserName(), permissions);
        return JSONObject.parseObject(JSONObject.toJSONString(new ReturnObject(userInfo)));
    }

    @RequestMapping("/auth/logout")
    public void logout(HttpSession httpSession){
        httpSession.invalidate();
    }

}




















