package com.dongnao.eventbus;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/18.
 */

public class Friend  implements Serializable {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Friend(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
