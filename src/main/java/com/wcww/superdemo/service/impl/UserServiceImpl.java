package com.wcww.superdemo.service.impl;

import com.wcww.superdemo.dao.UserDao;
import com.wcww.superdemo.entity.User;
import com.wcww.superdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public String signUp(User user) {
        User u = userDao.getUserByUsername(user.getUsername());
        if (u != null) {
            return "用户名已存在";
        } else {
            int r = userDao.insert(user);
            if (r <= 0) {
                return "数据库错误";
            } else {
                return null;
            }
        }
    }
}
