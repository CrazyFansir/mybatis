package com.cskaoyan.mapper;

import com.cskaoyan.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    int insertStudentList(@Param("students") List<Student> students);
}
