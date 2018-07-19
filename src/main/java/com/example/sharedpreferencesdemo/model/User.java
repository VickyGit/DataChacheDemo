package com.example.sharedpreferencesdemo.model;

import java.util.List;

/**
 * Created by Vicky on 2018/7/19.
 */

public class User {
    public String name;
    public String password;
    public List<Friend> friends;

    public User(String name, String password, List<Friend> friends) {
        this.name = name;
        this.password = password;
        this.friends = friends;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        if (friends!=null && friends.size()>0){

            return "UserInfo:name"+this.name+",password"+this.password+friends.toString();
        }else {
            return "UserInfo:name"+this.name+",password"+this.password;
        }
    }
}
