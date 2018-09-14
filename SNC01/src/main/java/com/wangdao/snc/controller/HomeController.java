package com.wangdao.snc.controller;

import com.wangdao.snc.bean.News;
import com.wangdao.snc.bean.User;
import com.wangdao.snc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(path={"/","/index"})
    public String home(Model model, HttpSession session){
        // 加载数据
        List<Map> vos = new ArrayList<>();
        List<News> newsList = newsService.findAllNews();
        for (News news : newsList) {
            Map map = new HashMap();
            map.put("news", news);
            map.put("user", news.getOwner());
            vos.add(map);
        }
        model.addAttribute("vos", vos);
        //User user = new User();
        //user.setName("admin");
        //user.setId(1);
        //session.setAttribute("user",user);
        //model.addAttribute("pop",null);

        Object user = session.getAttribute("user");
        if(user == null){
            model.addAttribute("pop",1);
        }
        return "home";
    }




}
