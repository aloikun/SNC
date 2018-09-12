package com.wangdao.snc.bean;

import java.util.Date;

public class News {
    // 符引id
    private Integer id;
    // 信息创建时间
    private Date createdDate;
    // 信息图片
    private String image;

    private String title;

    private String link;

    private String commentCount;

    private Integer like;

    private Integer likeCount;

    private Integer unlikeCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getUnlikeCount() {
        return unlikeCount;
    }

    public void setUnlikeCount(Integer unlikeCount) {
        this.unlikeCount = unlikeCount;
    }
}
