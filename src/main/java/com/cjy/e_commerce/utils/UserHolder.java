package com.cjy.e_commerce.utils;

import com.cjy.e_commerce.entity.User;
/**
 * 基于ThreadLocal封装工具类，用户保存
 */
public class UserHolder {
    private static final ThreadLocal<User> tl = new ThreadLocal<>();

    public static void saveUser(User user){
        tl.set(user);
    }

    public static User getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
