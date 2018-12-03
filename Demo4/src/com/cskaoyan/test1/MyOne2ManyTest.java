package com.cskaoyan.test1;

import com.cskaoyan.bean.Clazz;
import com.cskaoyan.bean.Cource;
import com.cskaoyan.bean.Student;
import com.cskaoyan.mapper.ClazzMapper;
import com.cskaoyan.mapper.CourceMapper;
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
    public void insertStudentsTest(){
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String studentName = "C++student" + i;
            int age = i;
            int roomNumber = 500 + i;
            String phoneNumber = "12355231545";
            student.setId(uuid);
            student.setStudentName(studentName);
            student.setAge(age);
            student.setRoomNumber(roomNumber);
            student.setPhoneNumber(phoneNumber);
            student.setClassId("d7abddd0f3d211e88fd568f7283f379c");
            students.add(student);
        }
        System.out.println(students.size());
        sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int i = mapper.insertStudentList(students);
        System.out.println("insert = " + i);

    }
    @Test
    public void myTest(){
        ClazzMapper mapper = sqlSessionFactory.openSession().getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectClazzAndStudentList("7cf45a29f3d211e88fd568f7283f379c");
        System.out.println("clazz = " + clazz);
        System.out.println("studentSize=" + clazz.getStudentList().size());
    }
    @Test
    public void myTest2(){
        ClazzMapper mapper = sqlSessionFactory.openSession().getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectClazzAndStudentList3("7cf45a29f3d211e88fd568f7283f379c");
        System.out.println("clazz = " + clazz);
        System.out.println("studentSize=" + clazz.getStudentList().size());
    }

    @Test
    public void myTest3(){
        ClazzMapper mapper = sqlSessionFactory.openSession().getMapper(ClazzMapper.class);
        List<Clazz> clazzes = mapper.selectClazzList();
        System.out.println(clazzes);
        System.out.println("班级1的人数" + clazzes.get(0).getStudentList().size());
        System.out.println("班级2的人数" + clazzes.get(1).getStudentList().size());
    }
    @Test
    public void myTest4(){
        ClazzMapper mapper = sqlSessionFactory.openSession().getMapper(ClazzMapper.class);
        List<Clazz> clazzes = mapper.selectClazzList2();
        System.out.println(clazzes);
        System.out.println("班级1的人数" + clazzes.get(0).getStudentList().size());
        System.out.println("班级2的人数" + clazzes.get(1).getStudentList().size());
    }
    @Test
    public void myTest5(){
        CourceMapper mapper = sqlSessionFactory.openSession().getMapper(CourceMapper.class);
        Cource cource = mapper.selectCourceById("45321f0af48311e88fd568f7283f379c");
        System.out.println(cource);
        System.out.println(cource.getStudents().size());
    }
    @Test
    public void myTest6(){
        CourceMapper mapper = sqlSessionFactory.openSession().getMapper(CourceMapper.class);
        List<Cource> cources = mapper.selectCources();
        System.out.println(cources);

        for (Cource cource: cources)
        {
            System.out.println(cource.getCourceName() +" 的学生数：" + cource.getStudents().size());

        }
    }

}
