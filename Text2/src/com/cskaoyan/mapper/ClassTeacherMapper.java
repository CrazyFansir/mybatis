package com.cskaoyan.mapper;

import com.cskaoyan.bean.ClassTeacher;
import org.apache.ibatis.annotations.Param;

public interface ClassTeacherMapper {

    //分次查询
    ClassTeacher selectTeacherById(@Param("id") String id);
    //连接查询
    ClassTeacher selectTeacherById2(@Param("id") String id);


}
