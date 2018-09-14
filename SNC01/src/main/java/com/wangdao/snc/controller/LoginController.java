package com.wangdao.snc.controller;

import com.wangdao.snc.bean.User;
import com.wangdao.snc.bean.customize.OResult;
import com.wangdao.snc.service.NewsService;
import com.wangdao.snc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/login/")
    @ResponseBody
    public OResult login(User user, Model model, HttpSession session){
        OResult oResult = new OResult();
        User login = userService.login(user);
        if(login != null){
            oResult.setCode(0);
            session.setAttribute("user",login);
            model.addAttribute("pop",null);
            model.addAttribute(oResult);
            return oResult;
        }else{
            oResult.setMsgname("账号错误");
            oResult.setMsgpwd("密码错误");
        }
        model.addAttribute(oResult);
        return oResult;
    }

    @RequestMapping("/reg/")
    @ResponseBody
    public OResult reg(User user) throws Exception{
        OResult oResult = new OResult();
        if(user == null){
            return null;
        }
        user.setName(user.getUsername());
        user.setHeadUrl("http://img.sccnn.com/bimg/338/27467.jpg");
        int result = userService.register(user);
        if(result == 1){
            oResult.setCode(0);
        }else if( result == -1){
            oResult.setMsgname("用户名已存在");
        }else{
            oResult.setMsgpwd("密码过于简单");
        }
        return oResult;
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }


}
