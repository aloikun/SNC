package com.wangdao.snc.bean;

import java.util.Date;

public class Comment {

    private int id;

    private Integer newsId;

    private String content;

    private Date createdDate;

    // 那个用户评论的id
    private int uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "newsId=" + newsId +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", uid=" + uid +
                '}';
    }
}
