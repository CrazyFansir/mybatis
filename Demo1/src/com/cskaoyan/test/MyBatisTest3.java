package com.cskaoyan.test;

import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MyBatisTest3 {

    //初始化factory
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception{
        String resource = "conf.xml";
        //直接读取编译路径下的文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //sqlSessionFactory sqlSession
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void getUserDaoTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        try {
            User user = userDao.selectUserById2("5bca0142f37a11e88fd568f7283f379c");

            System.out.println("user = " + user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void getUserDaoTest2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        try {
            User user = userDao.selectUserById2("5bca0142f37a11e88fd568f7283f379c");

            System.out.println("user = " + user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
