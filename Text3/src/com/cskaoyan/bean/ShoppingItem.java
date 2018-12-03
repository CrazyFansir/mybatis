package com.cskaoyan.bean;

import java.util.List;

public class ShoppingItem {
    private int itemid;
    private int sid;
    private String pid;
    private Product product;
    private int snum;

    public ShoppingItem(int sid, String pid, int snum) {
        this.sid = sid;
        this.pid = pid;
        this.snum = snum;
    }

    public ShoppingItem(int sid, String pid) {
        this.sid = sid;
        this.pid = pid;
    }

    public ShoppingItem() {
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "itemid=" + itemid +
                ", sid=" + sid +
                ", pid='" + pid + '\'' +
                ", product=" + product +
                ", snum=" + snum +
                '}';
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSnum() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
