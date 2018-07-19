package com.example.sharedpreferencesdemo.model;

/**
 * Created by Vicky on 2018/7/19.
 */

public class Friend {
    private String name;
    private String password;

    public Friend(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "FriendInfo:name"+this.name+",password"+this.password;
    }
}
