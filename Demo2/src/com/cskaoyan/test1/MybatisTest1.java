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
import java.util.HashMap;

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
    }
    @After
    public void commitAndClose(){
        if (sqlSession != null)
        {
            sqlSession.commit();
            sqlSession.close();
        }

    }

    @Test
    public void mytest1(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //sqlSession.selectOne("","")
        //User xiaoming = mapper.selectUserById("a2981142f3a111e88fd568f7283f379c\' or 1 = 1 or 1 != \'");
        //User xiaoming2 = mapper.selectUserById2("a2981142f3a111e88fd568f7283f379c\' or 1 = 1 or 1 != \'");
        //System.out.println("xiaoming =" + xiaoming);
        User xiaoming = mapper.selectUserById("a2981142f3a111e88fd568f7283f379c");
        System.out.println("xiaoming2 =" + xiaoming);
    }

    @Test
    public void myTestPojo(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("爱新觉罗", "2121", null, "axjl@cskaoyan.com", "male", 99);

        int i = mapper.insertUser(user);
        System.out.println("insertUser = " + i);
        User user2 = new User("爱新觉罗二世", "2121", null, "axjl@cskaoyan.com", "male", 99);

        int insertUser2 = mapper.insertUser2(user2);
        System.out.println("isnertUser2 = " + insertUser2);
    }
    @Test
    public void myTestMultiParam(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user2 = new User("爱新觉罗二世改名", "2121999", null, "axjl@cskaoyan.com", "male", 99);
        String id = "2ee87237f3a611e88fd568f7283f379c";
        mapper.updateUserById(user2,id);
    }
    @Test
    public void myTestMultiParam2(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //User user2 = new User("爱新觉罗二世改名", "2121999", null, "axjl@cskaoyan.com", "male", 99);
        String username = "aixinjueluo";
        String password = "19001018";
        String id = "2ee87237f3a611e88fd568f7283f379c";
        mapper.updateUserById2(username,password,id);
    }
    @Test
    public void myTestMultiParamByAnno(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user2 = new User("爱新觉罗二世", "123456", null, "axjl@cskaoyan.com", "male", 99);
        String id = "2ee87237f3a611e88fd568f7283f379c";
        mapper.updateUserByIdByAnno(user2,id);
    }
    @Test
    public void myTestMultiParamByAnno2(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username = "爱新觉罗_zhujie";
        String password = "zhujieword";
        String id = "2ee87237f3a611e88fd568f7283f379c";
        int i = mapper.updateUserById2ByAnno(username, password, id);
        System.out.println("update = " + i);
    }
    @Test
    public void updateByMap(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("username","aixinjueluo_Map");
        userMap.put("password","dfskjfk");
        String id = "2ee87237f3a611e88fd568f7283f379c";
        int i = mapper.updateUserByIdByMap(userMap, id);
        System.out.println("update = " + i);
    }
    @Test
    public void updateByMap2(){
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("username","aixinjueluo_Map2");
        userMap.put("password","123456");
        String id = "2ee87237f3a611e88fd568f7283f379c";
        int i = mapper.updateUserById2ByMap(userMap, id);
        System.out.println("update = " + i);
    }
}
