package com.zhangqie.aroutermodel.bean;

import java.io.Serializable;

public class ARouterBean implements Serializable {

    public ARouterBean() {

    }

    public ARouterBean(int id, String name) {
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
