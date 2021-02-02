package com.zhangqie.order.bean;

import java.io.Serializable;



public class OrderBean implements Serializable {

    public OrderBean() {

    }

    public OrderBean(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

}
