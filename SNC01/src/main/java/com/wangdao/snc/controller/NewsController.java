package com.wangdao.snc.controller;

import com.wangdao.snc.bean.Comment;
import com.wangdao.snc.bean.News;
import com.wangdao.snc.bean.User;
import com.wangdao.snc.bean.customize.OResult;
import com.wangdao.snc.service.NewsService;
import com.wangdao.snc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class NewsController {

    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;


    @RequestMapping("/uploadImage")
    @ResponseBody
    public OResult uploadImage(@RequestParam("file") MultipartFile image) throws IOException {
        OResult oResult = new OResult();
        // 获取文件根路径
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();

        File root = new File(path+"/static/pic/");

        String oFilename = image.getOriginalFilename();

        String suffix = oFilename.substring(oFilename.lastIndexOf("."));
        String filename = UUID.randomUUID().toString().replace("-", "");
        File dest = new File(root.getPath()+"/"+filename+suffix);
        image.transferTo(dest);
        // 文件在服务器上的地址
        oResult.setMsg("/pic/"+filename+suffix);
        oResult.setCode(0);
        return oResult;
    }


    @RequestMapping("/news/{id}")
    public String findDetails(Model model, @PathVariable Integer id){
        News news = newsService.findNewsById(id);
        // 显示其评论
        List<Map> comments = new ArrayList<>();
        List<Comment> commentList = newsService.findCommentByNewId(news.getId());
        for (Comment comment: commentList) {
            User user = userService.findUserById(comment.getUid());
            Map map = new HashMap();
            map.put("user",user);
            map.put("comment", comment);
            comments.add(map);
        }
        model.addAttribute("news",news);
        model.addAttribute("owner",news.getOwner());
        model.addAttribute("comments",comments);
        return "detail";
    }

    @RequestMapping("/addComment")
    public String addComment(Comment comment, HttpSession session) throws Exception{
        User user = (User) session.getAttribute("user");
        comment.setUid(user.getId()); // 存放用户id
        int i = newsService.addComment(comment);
        if(i == 1){
            return "news/"+comment.getNewsId();
        }else{
            throw new Exception("error!");
        }
    }

}
