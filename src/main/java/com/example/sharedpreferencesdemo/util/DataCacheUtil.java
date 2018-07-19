package com.example.sharedpreferencesdemo.util;

import android.content.Context;

import com.example.sharedpreferencesdemo.model.User;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Vicky on 2018/7/19.
 */

public class DataCacheUtil {

    private SharedPreferencesUtils mSharedPreferences;
    private static DataCacheUtil mInstance;

    /**
     * 通过单例模式实例化对象
     * @param context
     */
    private DataCacheUtil(Context context){
        mSharedPreferences=new SharedPreferencesUtils(context);
    }

    /**
     * 调用构造函数时，传入context.getApplicationContext()
     * @param context
     * @return
     */
    public static DataCacheUtil getInstance(Context context){
        if (mInstance==null){
            synchronized (DataCacheUtil.class){
                if (mInstance==null){
                    mInstance=new DataCacheUtil(context.getApplicationContext());
                }
            }
        }
        return mInstance;
    }


    /**
     * 保存单个用户数据存储
     * @param user
     */
    public void saveUser(User user){
        mSharedPreferences.saveObject("user_info",user);
    }

    /**
     * 获取单个用户数据
     * @return
     */
    public User getUser(){
        return mSharedPreferences.getObject("user_info",User.class);
    }


    /**
     * 保存List<User>对象
     * @param users
     */
    public void saveUserList(List<User> users){
        mSharedPreferences.saveList("user_list_info",users);
    }

    /**
     * 获取List<User>对象
     * @return
     */
    public List<User> getUserList(){
        return  mSharedPreferences.getList("user_list_info",new TypeToken<List<User>>(){});
    }

    /**
     * 保存User对象,对象中包括List<Friend>列表
     * @return
     */
    public void saveUserWithFriend(User user){
        mSharedPreferences.saveObject("user_with_friend",user);
    }

    /**
     * 获取User对象,对象中包括List<Friend>列表
     * @return
     */
    public User getUserWithFriend(){
        return mSharedPreferences.getObject("user_with_friend",User.class);
    }
}
