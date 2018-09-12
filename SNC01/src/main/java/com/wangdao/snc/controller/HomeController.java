package com.wangdao.snc.controller;

import com.wangdao.snc.bean.News;
import com.wangdao.snc.bean.User;
import com.wangdao.snc.bean.vo.NewsVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {



    @RequestMapping("/")
    public String home(Model model){

        User user = new User();
        user.setName("test");
        model.addAttribute("user",user);

        List<NewsVo> vos = new ArrayList<>();

        //
        NewsVo vo = new NewsVo();
        News news1 = new News();
        news1.setTitle("百度，只为测试");
        news1.setLink("http://wwww.baidu.com");
        news1.setLikeCount(100);
        news1.setUnlikeCount(100);
        Date date = new Date();
        news1.setCreatedDate(date);
        vo.setNews(news1);
        vo.setUser(user);
        vos.add(vo);

        NewsVo vo1 = new NewsVo();
        News news2 = new News();
        news2.setTitle("百度，只为测试");
        news2.setLink("http://wwww.baidu.com");
        news2.setCreatedDate(date);
        news2.setLike(1);
        vo1.setNews(news2);
        vo1.setUser(user);
        vos.add(vo1);

        model.addAttribute("vos", vos);
        // 登录弹框
        model.addAttribute("pop",null);
        return "home";
    }
}
