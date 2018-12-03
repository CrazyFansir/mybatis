package com.cskaoyan.bean;

import java.util.List;

public class ShoppingCar  <ShoppingItem>{
    private List<ShoppingItem> shoppingItems;
    private int uid;
    private int sid;

    public List<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(List<ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
}
