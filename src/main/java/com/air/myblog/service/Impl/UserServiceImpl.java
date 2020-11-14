package com.air.myblog.service.Impl;

import com.air.myblog.Dao.UserDao;
import com.air.myblog.entity.User;
import com.air.myblog.service.UserService;
import com.air.myblog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author air
 * @create 2020-10-26-23:29
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        return userDao.findByUsernameAndPassword(username, MD5Util.code(password));
    }
}
