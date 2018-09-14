package com.wangdao.snc.service;

import com.wangdao.snc.bean.Comment;
import com.wangdao.snc.bean.News;

import java.util.List;

public interface NewsService {

    List<News> findAllNews();

    int insertNews(News news);

    News findNewsById(Integer id);

    int addComment(Comment comment);

    List<Comment> findCommentByNewId(Integer id);
}
