package com.wangdao.snc.controller;

import com.wangdao.snc.bean.customize.OResult;
import com.wangdao.snc.service.NewsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LikeController {

    @Autowired
    private NewsService newsService;

    /**
     *
     * @param newsId 指定要点赞的新闻
     * @return
     */
    @RequestMapping(value = "/like", method = {RequestMethod.GET, RequestMethod.POST})
    public OResult like(@Param("newsId") Integer newsId){
        // 根据newsId 查询 点赞数
        //newsService.findLikeCountbyId(newId);
        return null;
    }
}
