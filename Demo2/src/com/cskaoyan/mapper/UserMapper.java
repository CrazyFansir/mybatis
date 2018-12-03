package com.cskaoyan.mapper;

import com.cskaoyan.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface UserMapper {
    User selectUserById(String id);
    User selectUserById2(@Param("idxxxx") String id);

    int insertUser(User user);
    int insertUser2(@Param("user2") User user);

    //两个参数或多个参数 以param1 param2 开始一直到paramn
    int updateUserById(User user, String id);
    int updateUserById2(String username, String password, String id);
    //通过注解传入两个及以上的参数 使用的是注解里的值
    int updateUserByIdByAnno(@Param("userz") User user, @Param("idz") String id);
    int updateUserById2ByAnno(@Param("usernamez") String username,
                              @Param("passwordz") String password,
                              @Param("idz") String id);
    int updateUserByIdByMap(HashMap<String, String> map, String id);
    int updateUserById2ByMap(@Param("mapz") HashMap<String, String> map,
                             @Param("idx") String id);

}
