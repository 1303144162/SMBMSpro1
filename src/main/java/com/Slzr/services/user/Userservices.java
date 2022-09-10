package com.Slzr.services.user;

import com.Slzr.entity.User;


import java.sql.SQLException;
import java.util.List;

public interface  Userservices {
    //登录密码
    public User LoginUser(String username,String pwd);
    //id更改密码
    public boolean updatePwd(int id,String pwd);
    //用户数量
    public int getUserCount(String username,int userrole);
    //用户列表
    public List<User> getListUser( String username, int rolecode, int pageNo, int pageSize) throws SQLException, Exception;
}
