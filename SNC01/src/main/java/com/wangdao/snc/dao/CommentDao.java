package com.wangdao.snc.dao;


import com.wangdao.snc.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {

    List<Comment> selectCommentsByNewId(Integer id);

    int insert(Comment comment);

}
