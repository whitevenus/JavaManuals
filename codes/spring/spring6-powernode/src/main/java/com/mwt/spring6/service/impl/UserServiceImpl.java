package com.mwt.spring6.service.impl;

import com.mwt.spring6.dao.UserDao;
import com.mwt.spring6.dao.impl.UserDaoImplForMySQL;
import com.mwt.spring6.dao.impl.UserDaoImplForOracle;
import com.mwt.spring6.service.UserService;

public class UserServiceImpl implements UserService {

//    private UserDao userDao = new UserDaoImplForOracle();

    private UserDao userDao = new UserDaoImplForMySQL();

    @Override
    public void deleteUser() {
        // 调用持久层方法
        userDao.deleteById();
    }
}
