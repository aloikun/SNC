package com.wangdao.snc.service.impl;

import com.wangdao.snc.bean.Comment;
import com.wangdao.snc.bean.News;
import com.wangdao.snc.dao.CommentDao;
import com.wangdao.snc.dao.NewsDao;
import com.wangdao.snc.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private CommentDao commentDao;
    @Override
    public List<News> findAllNews() {
        return newsDao.selectAllNews();
    }

    @Override
    public int insertNews(News news) {
        return newsDao.insert(news);
    }

    @Override
    public News findNewsById(Integer id) {
        return newsDao.selectByPrimaryKey(id);
    }

    @Override
    public int addComment(Comment comment) {
        newsDao.updateCommentCountByNewsId(comment.getNewsId());
        return commentDao.insert(comment);
    }


    @Override
    public List<Comment> findCommentByNewId(Integer id) {
        return commentDao.selectCommentsByNewId(id);
    }
}
