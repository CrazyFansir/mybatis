package com.cskaoyan.mapper;

import com.cskaoyan.bean.ShoppingCar;
import com.cskaoyan.bean.ShoppingItem;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface ShoppingCartMapper {
    List<ShoppingItem> findShopingItemsBypid(@Param("pid") String pid) ;
    ShoppingCar findShoppingCartBySid(@Param("sid") int sid);
    int deleteItem(int itemId) ;
    List<ShoppingItem> findAllItem(int sid) ;
    int isExist(String pid, int sid) ;
    int deletAll(int sid);
}
