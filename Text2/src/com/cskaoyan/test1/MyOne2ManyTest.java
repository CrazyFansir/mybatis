package com.cskaoyan.test1;

import com.cskaoyan.bean.Clazz;
import com.cskaoyan.bean.Cource;
import com.cskaoyan.bean.Student;
import com.cskaoyan.mapper.ClazzMapper;
import com.cskaoyan.mapper.CourceMapper;
import com.cskaoyan.mapper.SearchStudentMapper;
import com.cskaoyan.mapper.StudentMapper;
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

public class MyOne2ManyTest {

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
    public  void test1(){
        SearchStudentMapper mapper = sqlSessionFactory.openSession().getMapper(SearchStudentMapper.class);
        Student student=new Student();
        student.setStudentName("%C++%");
        student.setAge(18);
        List<Student> students = mapper.searchStudents(student);
        System.out.println(students);

    }
}
