package com.cskaoyan.mapper;

import com.cskaoyan.bean.J11Bean;
import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface UserMapper {

    String selectUserNameById(@Param("id") String id);
    int selectCount();

    List<User> selectUsers(@Param("username") String username);
    List<User> selectUsers2(@Param("username") String username);
    List<J11Bean> selectUsers3(@Param("username") String username);

    //where 标签
    User selectUserById(String id);
    //if 标签
    List<User> selectUserByIdIf(@Param("username") String name,
                                @Param("age") int age);
    //带注解的foreach
    int insertUserList(@Param("users") ArrayList<User> users);
    //不带注解的foreach
    int insertUserList2(ArrayList<User> users);
    //Foreach的open和close
    List<User> selectUserIdIn(@Param("ids") List<String> ids);

    int insertUserArray(@Param("users") User[] users);
}
