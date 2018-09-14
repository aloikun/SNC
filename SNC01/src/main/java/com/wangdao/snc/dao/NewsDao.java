package com.wangdao.snc.dao;

import com.wangdao.snc.bean.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsDao {

    News selectByPrimaryKey(Integer id);

    List<News> selectAllNews();

    int insert(News news);

    int updateCommentCountByNewsId(int i);

}
