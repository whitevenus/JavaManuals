package com.mwt.spring6.dao.impl;

import com.mwt.spring6.dao.UserDao;

public class UserDaoImplForOracle implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("Oracle数据库正在删除用户信息.....");
    }
}
