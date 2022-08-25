package com.Slzr.dao.user;

import com.Slzr.entity.User;

import java.sql.Connection;

public interface UserDao {
    public User getUserCodeEnt(Connection c, String Usercode);
}
