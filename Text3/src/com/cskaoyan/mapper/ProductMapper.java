package com.cskaoyan.mapper;

import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface ProductMapper {
    int  addProduct(Product product) ;
    int  deleteProduct(Product product) ;
    int updateProduct(Product product) ;
    List<Product> findProductByCategory(@Param("category") Category category) ;
    List<Product> findAllProduct() ;

    int findTotalNumber() throws SQLException;

    List<Product> findOnePageProduct(int limit, int offset) throws SQLException;
    boolean isExist(Product product) throws SQLException;
    Product findProductByPid(String pid) throws SQLException;

    Boolean placeProduct(String pids, Integer buynum) throws SQLException;
}
