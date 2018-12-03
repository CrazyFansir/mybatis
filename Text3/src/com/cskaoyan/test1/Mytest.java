package com.cskaoyan.test1;

import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.ShoppingItem;
import com.cskaoyan.mapper.CategoryMapper;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.mapper.ShoppingCartMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Mytest {
    private SqlSessionFactory sqlSessionFactory;
    //sqlSession 是线程不安全的
    private SqlSession sqlSession;
    @Before
    public void init() throws Exception{
        String resource = "conf.xml";
        //直接读取编译路径下的文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //sqlSessionFactory sqlSession
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        System.out.println("init 方法");
    }
    @After
    public void commitAndClose(){
        System.out.println("close");
        if (sqlSession != null)
        {
            sqlSession.commit();
            sqlSession.close();
        }

    }

    @Test
    public void test1()
    {
        ProductMapper mapper = sqlSessionFactory.openSession().getMapper(ProductMapper.class);
        List<Product> allProduct = mapper.findAllProduct();
        System.out.println(allProduct);
    }
    @Test
    public void test2()
    {
        ProductMapper mapper = sqlSessionFactory.openSession().getMapper(ProductMapper.class);
        List<Product> allProduct = mapper.findProductByCategory(new Category(5));
        System.out.println(allProduct);
    }
    @Test
    public void test3()
    {
        CategoryMapper mapper = sqlSessionFactory.openSession().getMapper(CategoryMapper.class);
        Category categoryBycid = mapper.findCategoryBycid(5);
        System.out.println(categoryBycid);
    }
    @Test
    public void test4()
    {
        ShoppingCartMapper mapper = sqlSessionFactory.openSession().getMapper(ShoppingCartMapper.class);
        List<ShoppingItem> ac1 = mapper.findShopingItemsBypid("ac1");
        System.out.println(ac1);
    }
}
