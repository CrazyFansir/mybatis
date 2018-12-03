package com.cskaoyan.mapper;

import com.cskaoyan.bean.User;

public interface UserMapper {
    User selectUserById2(String id) throws Exception;
    User selectUserById(String id) throws Exception;
    User selectUser(String id);
}
