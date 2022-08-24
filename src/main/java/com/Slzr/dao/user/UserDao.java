package com.Slzr.dao.user;

import java.sql.Connection;

public interface UserDao {
    public void getUserCode(Connection c,String Usercode);
}
