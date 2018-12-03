package com.cskaoyan.test1;

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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MybatisTest2 {
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
    public void myWhereTest1(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById("01fe4f6af3a511e88fd568f7283f379c");
        System.out.println(user);
    }
    @Test
    public void myIfTest(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUserByIdIf("爱新觉罗", 99);
        System.out.println(users);
        System.out.println(users.size());
    }
//    foreach标签
    @Test
    public void myForeachTest(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<User> users = new ArrayList<>();
        String id1 = UUID.randomUUID().toString().replaceAll("-", "");
        String id2 = UUID.randomUUID().toString().replaceAll("-", "");
        String id3 = UUID.randomUUID().toString().replaceAll("-", "");
        String password = "lanzhao234";
        String username1 = "lanzhao4";
        String username2 = "lanzhao5";
        String username3 = "lanzhao6";
        User user1 = new User(username1,password,id1,"asd@cskaoyan.com","male",40);
        User user2 = new User(username2,password,id2,"asd@cskaoyan.com","male",40);
        User user3 = new User(username3,password,id3,"asd@cskaoyan.com","male",40);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        int i = mapper.insertUserList(users);
        System.out.println("i=" + i);
        //构建好user的list，接下来插入数据库
        /*for (User user: users
             ) {

        }*/

    }
    //foreach的集合未使用注解 使用list
    @Test
    public void myForeachTest2(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<User> users = new ArrayList<>();
        String id1 = UUID.randomUUID().toString().replaceAll("-", "");
        String id2 = UUID.randomUUID().toString().replaceAll("-", "");
        String id3 = UUID.randomUUID().toString().replaceAll("-", "");
        String password = "lanzhao234";
        String username1 = "lanzhao4";
        String username2 = "lanzhao5";
        String username3 = "lanzhao6";
        User user1 = new User(username1,password,id1,"asd@cskaoyan.com","male",40);
        User user2 = new User(username2,password,id2,"asd@cskaoyan.com","male",40);
        User user3 = new User(username3,password,id3,"asd@cskaoyan.com","male",40);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        int i = mapper.insertUserList2(users);
        System.out.println("i=" + i);
        //构建好user的list，接下来插入数据库
        /*for (User user: users
             ) {

        }*/

    }
    //foreach的集合未使用注解 使用array
    @Test
    public void myForeachTest3(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User[] users = new User[3];
        //ArrayList<User> users = new ArrayList<>();
        String id1 = UUID.randomUUID().toString().replaceAll("-", "");
        String id2 = UUID.randomUUID().toString().replaceAll("-", "");
        String id3 = UUID.randomUUID().toString().replaceAll("-", "");
        String password = "lanzhao234";
        String username1 = "lanzhao4";
        String username2 = "lanzhao5";
        String username3 = "lanzhao6";
        User user1 = new User(username1,password,id1,"asd@cskaoyan.com","male",40);
        User user2 = new User(username2,password,id2,"asd@cskaoyan.com","male",40);
        User user3 = new User(username3,password,id3,"asd@cskaoyan.com","male",40);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        users[0]=user1;
        users[1]=user2;
        users[2]=user3;
        int i = mapper.insertUserArray(users);
        System.out.println("i=" + i);
        //构建好user的list，接下来插入数据库
        /*for (User user: users
             ) {

        }*/

    }
    @Test
    public void foreachOpenCloseTest(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String id1 = "acffe171d6054ccf8342cdf5f3746249";
        String id2 = "b461e980d98e45068c68513edfcaf883";
        String id3 = "c7ff4d3829784ebdb8d59d1039970130";
        ArrayList<String> ids = new ArrayList<>();
        ids.add(id1);
        ids.add(id2);
        ids.add(id3);
        System.out.println("ids = " +ids);

        List<User> users = mapper.selectUserIdIn(ids);
        System.out.println("users = " + users);

    }
}
