package com.wangdao.snc.bean.vo;

import com.wangdao.snc.bean.News;
import com.wangdao.snc.bean.User;

public class NewsVo {

    private News news;

    private User user;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "NewsVo{" +
                "news=" + news +
                ", user=" + user +
                '}';
    }
}
