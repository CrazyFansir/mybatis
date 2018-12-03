package com.cskaoyan.bean;

import java.util.List;

public class Category {
    private int cid;
    private String cname;
    List<Product> productlist;
    public Category() {
    }

    public Category(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public List<Product> getProductlist() {
        return productlist;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", productlist=" + productlist +
                '}';
    }

    public void setProductlist(List<Product> productlist) {
        this.productlist = productlist;
    }

    public Category(int cid) {
        this.cid = cid;
    }

    public Category(String cname) {

        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
