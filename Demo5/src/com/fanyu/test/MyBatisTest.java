package com.fanyu.test;

import com.fanyu.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        String resource = "configration.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

/*    @After
    public void commitAndClose() {
        System.out.println("close");
        if (sqlSession != null) {

            sqlSession.commit();
            sqlSession.close();
        }

    }*/

    @Test
    public void myText1() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();


        User user = sqlSession.selectOne("mynamespace.selectUser", 12);
        System.out.println(user);

    }

    @Test
    public void selcetlistTest() throws IOException {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("mynamespace.selcetUsers", 1333333333);
        System.out.println(users);
    }

    @Test
    public void insertTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setAge(17);
        user.setName("ergou");
        user.setNumber("133516546");

        int insert = sqlSession.insert("mynamespace.insertUser", user);

        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setAge(15);
        user.setName("tiezhu");
        user.setNumber("1334444443");
        user.setId("855c691af5f711e8876454ee752b3a10");


        int update = sqlSession.update("mynamespace.updateUser", user);


        System.out.println(update);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void delete(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        String id = "855c691af5f711e8876454ee752b3a10";

        int delete = sqlSession.delete("mynamespace.deleteUser", id);
        System.out.println(delete);

        sqlSession.commit();
        sqlSession.close();

    }

    Boyfriend boyfriend =  new Boyfriend();

    Girlfriend girlfriend =  new Girlfriend();


}
