package com.cskaoyan.mapper;

import com.cskaoyan.bean.Cource;
import com.cskaoyan.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourceMapper {

    Cource selectCourceById(@Param("id") String id);
    List<Cource> selectCources();
}
