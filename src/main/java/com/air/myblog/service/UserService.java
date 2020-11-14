package com.air.myblog.service;

import com.air.myblog.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author air
 * @create 2020-10-26-23:22
 */

public interface UserService {
    //核对用户名和密码
    User checkUser(String username, String password);
}
