package com.Slzr.dao.user;

import com.Slzr.entity.Role;
import com.Slzr.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //查找用户信息
    public User getUserCodeEnt(Connection c, String Usercode);
    //修改密码
    public int updatePwd(Connection conn,int id,String pwd) throws SQLException;
    //查询用户总数
    int getUserCount(Connection conn, String username, int rolecode) throws SQLException, Exception;
    //查询用户列表
     public List<User> getListUser(Connection conn, String username, int rolecode, int pageNo, int pageSize) throws SQLException, Exception;


}
