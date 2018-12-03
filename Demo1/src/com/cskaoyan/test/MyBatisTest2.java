package com.cskaoyan.test;

import com.cskaoyan.bean.User;
import com.cskaoyan.dao.impl.UserDaoImpl;
import com.cskaoyan.mapper.UserMapper;
import org.junit.Test;

public class MyBatisTest2 {
    @Test
    public void mytest(){
        UserMapper userDao = (UserMapper) new UserDaoImpl();
        try {
            User user = userDao.selectUserById("be290f58f3da11e8a6cb54ee752b3a10");
            System.out.println("shibushi zhangsan:" + user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
