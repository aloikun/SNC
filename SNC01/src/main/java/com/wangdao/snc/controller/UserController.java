package com.wangdao.snc.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wangdao.snc.bean.User;
import com.wangdao.snc.bean.customize.OResult;
import com.wangdao.snc.bean.json.JsonData;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @RequestMapping(value = "/login/")
    @ResponseBody
    public OResult login(String username, String password, Integer rember, Model model){
        OResult oResult = new OResult();
        if("admin".equals(username) && "123456".equals(password)){

            // 表示用户明密码正确
            oResult.setCode(0);
            User user = new User();
            user.setUsername("admin");
            user.setId(1);
        }else if(!"admin".equals(username)){
            oResult.setMsgname("账号错误");
        }else{
            oResult.setMsgpwd("密码错误");
        }

        model.addAttribute(oResult);
        //从前端获取到json 数据
        //oResult.setCode(0);
        return oResult;
    }

    @RequestMapping("/reg")
    @ResponseBody
    public OResult reg(String username, String password, Integer rember){
        //从前端获取到json 数据
        OResult oResult = new OResult();
        //oResult.setCode(0);
        oResult.setMsgname("name");
        oResult.setMsgpwd("1223");
        //System.out.println(user);
        //if(login == null && !login.equals("")){
        //    return null;
        //}
        //map.put("code","0");
        //map.put("msgname","msgname");
        //map.put("msgpwd","msgname");
        return oResult;
    }
}
