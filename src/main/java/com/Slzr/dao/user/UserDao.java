package com.Slzr.dao.user;

import com.Slzr.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    //查找用户信息
    public User getUserCodeEnt(Connection c, String Usercode);
    //修改密码
    public int updatePwd(Connection conn,int id,String pwd) throws SQLException;

}
