package com.mwt.spring6.web;

import com.mwt.spring6.service.UserService;
import com.mwt.spring6.service.impl.UserServiceImpl;

/**
 * 表示层
 */
public class UserAction {

    private UserService userService = new UserServiceImpl();

    // 删除用户信息请求
    public void deleteRequest() {
        userService.deleteUser();
    }
}
