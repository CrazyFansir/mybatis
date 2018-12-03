package com.cskaoyan.test1;

import com.cskaoyan.bean.ClassTeacher;
import com.cskaoyan.mapper.ClassTeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MyOne2OneTest {

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
    public void one2oneTest(){
        sqlSession = sqlSessionFactory.openSession();
        ClassTeacherMapper mapper = sqlSession.getMapper(ClassTeacherMapper.class);
        ClassTeacher classTeacher = mapper.selectTeacherById("6c2481a8f46c11e88fd568f7283f379c");
        System.out.println(classTeacher);
    }
    @Test
    public void one2oneTest2(){
        sqlSession = sqlSessionFactory.openSession();
        ClassTeacherMapper mapper = sqlSession.getMapper(ClassTeacherMapper.class);
        //使用连接查询的接口
        ClassTeacher classTeacher = mapper.selectTeacherById2("6c2481a8f46c11e88fd568f7283f379c");
        System.out.println(classTeacher);
    }

}
