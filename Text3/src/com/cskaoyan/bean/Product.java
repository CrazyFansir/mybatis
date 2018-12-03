package com.cskaoyan.bean;


import java.sql.Date;

public class Product {
    private String pid;
    private String pname;
    private double estoreprice;
    private double markprice;
    private int pnum;
    private int cid;
    private String imgurl;
    private String description;
    private String vendor;
   private String releasetime1;
    private Date releasetime;
    private Category category;

    public Product() {
    }

    public Product(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", estoreprice=" + estoreprice +
                ", markprice=" + markprice +
                ", pnum=" + pnum +
                ", cid=" + cid +
                ", imgurl='" + imgurl + '\'' +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", releasetime=" + releasetime +
                '}';
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getEstoreprice() {
        return estoreprice;
    }

    public void setEstoreprice(double estoreprice) {
        this.estoreprice = estoreprice;
    }

    public double getMarkprice() {
        return markprice;
    }

    public void setMarkprice(double markprice) {
        this.markprice = markprice;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }
    //    public String getReleasetime() {
//        return releasetime;
//    }
//
//    public void setReleasetime(String releasetime) {
//        this.releasetime = releasetime;
//    }

    public String getReleasetime1() {
        return releasetime1;
    }

    public void setReleasetime1(String releasetime1) {
        this.releasetime1 = releasetime1;
    }


}
