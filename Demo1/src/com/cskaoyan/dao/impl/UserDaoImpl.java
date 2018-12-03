package com.cskaoyan.dao.impl;

import com.cskaoyan.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserDaoImpl {

    SqlSessionFactory sqlSessionFactory = null;
    {
        try {
            String resource = "conf.xml";
            //直接读取编译路径下的文件
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            //sqlSessionFactory sqlSession
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public User selectUserById(String id) throws Exception{

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User o = sqlSession.selectOne("mynamespace.selectUserById", id);
        return o;
    }
}
