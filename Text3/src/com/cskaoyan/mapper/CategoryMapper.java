package com.cskaoyan.mapper;

import com.cskaoyan.bean.Category;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface CategoryMapper {
    Boolean addCategory(Category category) throws SQLException;
    Boolean deleteCategory(int cid) throws SQLException;
    Boolean updateCategory(Category category) throws SQLException;
    Category findCategoryBycid(@Param("cid") int cid);
    List<Category> findAllCategory() throws SQLException;
    List<Category> findOnePageCategory(int limit, int offset) throws SQLException;

    int findTotalNumber() throws SQLException;
    boolean isExist(Category category) throws SQLException;
}
