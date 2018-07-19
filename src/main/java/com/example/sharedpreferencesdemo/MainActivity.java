package com.example.sharedpreferencesdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.sharedpreferencesdemo.model.Friend;
import com.example.sharedpreferencesdemo.model.User;
import com.example.sharedpreferencesdemo.util.DataCacheUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vicky on 2018/7/19.
 */

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //存取单个User对象
        User user=new User("DaMai","DaMai123456");
        DataCacheUtil.getInstance(getApplicationContext()).saveUser(user);
        Log.d("DaMai",DataCacheUtil.getInstance(getApplicationContext()).getUser().name);

        List<User> userList=new ArrayList<>();
        for (int i=0;i<10;i++){
            User temUser=new User("DaMai"+i,"DaMaiPass"+i);
            userList.add(temUser);
        }

        DataCacheUtil.getInstance(getApplicationContext()).saveUserList(userList);
        List<User> users=DataCacheUtil.getInstance(this).getUserList();
        for (User item:userList){
            Log.d("DaMai",item.toString());
        }


        List<Friend> friends=new ArrayList<>();
        for (int i=0;i<10;i++){
            Friend temFriend=new Friend("DaMai friend"+i,"DaMaiFriendPass"+i);
            friends.add(temFriend);
        }
        User vicky=new User("vicky","vicky123456",friends);
        DataCacheUtil.getInstance(this).saveUserWithFriend(vicky);
        Log.d("DaMai",DataCacheUtil.getInstance(this).getUserWithFriend().toString());

    }

}
