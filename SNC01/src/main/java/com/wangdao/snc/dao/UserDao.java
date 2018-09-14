package com.wangdao.snc.dao;

import com.wangdao.snc.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    User selectByPrimaryKey(Integer id);

    User selectUserByUsername(String username);

    @Select("select * from `user` where username=#{username} and password = #{password}")
    User selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    int insert(User user);
}
