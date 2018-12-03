package com.cskaoyan.test1;

import com.cskaoyan.bean.J11Bean;
import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest1 {

    //初始化factory
    //sqlSessionFactory线程安全
    private SqlSessionFactory sqlSessionFactory;
    //sqlSession 是线程不安全的
    private SqlSession sqlSession;
    @Before
    public void init() throws Exception{
        String resource = "conf.xml";
        //直接读取编译路径下的文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //sqlSessionFactory sqlSession
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        System.out.println("init 方法");
    }
    @After
    public void commitAndClose(){
        System.out.println("close");
        if (sqlSession != null)
        {
            sqlSession.commit();
            sqlSession.close();
        }

    }
    @Test
    public void outputTest1(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        String id = "2ee87237f3a611e88fd568f7283f379c";
        String username = userMapper.selectUserNameById(id);
        System.out.println("username = " + username);

        //查询int型
        int i = userMapper.selectCount();
        System.out.println("条目数：" + i);
    }
    @Test
    public void outputTest2(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectUsers("爱新觉罗");
        System.out.println("users=" + users);
        System.out.println("users size = " + users.size());
    }
    @Test
    public void outputTest3(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectUsers2("爱新觉罗");
        System.out.println("users=" + users);
        System.out.println("users size = " + users.size());
    }
    @Test
    public void outputTest4(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<J11Bean> j11Beans = userMapper.selectUsers3("爱新觉罗");
        System.out.println("j11beans = " + j11Beans);
        String param = "Wangdao_java_spring_liu";
        String param2 = "wangdaoJavaSpringLiu";
    }




}
