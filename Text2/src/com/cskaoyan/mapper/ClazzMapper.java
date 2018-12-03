package com.cskaoyan.mapper;

import com.cskaoyan.bean.Clazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClazzMapper {

    Clazz selectClazzAndStudentList(@Param("id") String id);
    Clazz selectClazzAndStudentList3(@Param("id") String id);
    //通过collect的select查询
    List<Clazz> selectClazzList();
    //通过连接查询
    List<Clazz> selectClazzList2();
}
