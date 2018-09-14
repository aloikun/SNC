package com.wangdao.snc.service.impl;

import com.wangdao.snc.bean.User;
import com.wangdao.snc.dao.UserDao;
import com.wangdao.snc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int register(User user) {
        User u = userDao.selectUserByUsername(user.getUsername());
        if(u != null){
            return -1;
        }
        return userDao.insert(user);
    }

    @Override
    public User login(User user) {
        User u = userDao.selectUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        return u;
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }
}
