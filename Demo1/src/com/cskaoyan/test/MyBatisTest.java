package com.cskaoyan.test;

import com.cskaoyan.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MyBatisTest {

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
    public void myTest1() throws Exception{

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // namespace+id
        //selectOne 方法
        User user = sqlSession.selectOne("mynamespace.selectUser", 25);

        System.out.println("user = " + user);
        sqlSession.close();
    }
    //List
    @Test
    public void selectListTest() throws Exception
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //传参数的时候 基本类型 只传了一个 #{param} 这边随便写
        //其他domo会满足
        List<User> users = sqlSession.selectList("com.cskaoyan.mapper.UserMapper.selectUsers", "lisi");
        System.out.println("users = " + users);
        sqlSession.close();
    }
    @Test
    public void insertTest() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /*User user = new User();
        user.setUsername("lisi");
        user.setPassword("654321");
        user.setEmail("lisi@sckaoyan.com");
        user.setGender("male");*/
        User user = new User("lisi", "2121", null, "lisi@cskaoyan.com", "male", 21);
        int insert = sqlSession.insert("com.cskaoyan.mapper.UserMapper.insertUser", user);
        System.out.println("insert number =" + insert);
        //mybatis事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateTest() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("654321");
        user.setEmail("lisi@sckaoyan.com");
        user.setGender("female");
        user.setAge(30);
        user.setId("be290f58f3da11e8a6cb54ee752b3a10");
        int update = sqlSession.update("com.cskaoyan.mapper.UserMapper.updateUser", user);
        System.out.println("update = " + update);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteTest() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String id = "c595c55ef37f11e88fd568f7283f379c";
        int delete = sqlSession.delete("mynamespace.deleteUser", id);
        System.out.println("delte = " + delete);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void hashmapTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HashMap<String, String> map = new HashMap<>();
        map.put("username","zhangliu");
        map.put("password","55555");
        map.put("email","zhaoliu@cskaoyan.com");
        int insert = sqlSession.insert("mynamespace.insertUserbyMap", map);
        sqlSession.commit();
        sqlSession.close();
    }
}
