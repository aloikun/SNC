package com.wangdao.snc.controller;

import com.wangdao.snc.bean.News;
import com.wangdao.snc.bean.User;
import com.wangdao.snc.bean.customize.OResult;
import com.wangdao.snc.service.NewsService;
import com.wangdao.snc.service.UserService;
import javafx.beans.binding.ObjectExpression;
import org.apache.struts.chain.commands.ExceptionCatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;



    @RequestMapping("/user/{id}")
    public String find(@PathVariable Integer id, Model model) throws Exception {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "personal";
    }

    @RequestMapping("/user/tosendmsg")
    public String tosendmsg(Model model){

        return "letter";
    }

    @RequestMapping("/user/addNews")
    @ResponseBody
    public OResult addNews(News news, HttpSession session) throws Exception{
        User user = (User) session.getAttribute("user");
        OResult oResult = new OResult();
        news.setUid(user.getId());
        news.setCreatedDate(new Date());
        int i = newsService.insertNews(news);
        if(i == 1){ // 添加成功
            oResult.setCode(0);
        }else{
            oResult.setMsg("出现错误");
        }
        return oResult;
    }




}
