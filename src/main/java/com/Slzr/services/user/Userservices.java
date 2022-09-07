package com.Slzr.services.user;

import com.Slzr.entity.User;

public interface  Userservices {
    //登录密码
    public User LoginUser(String username,String pwd);
    //id更改密码
    public boolean updatePwd(int id,String pwd);
}
