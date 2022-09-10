package com.Slzr.dao.Role;

import com.Slzr.entity.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoleDao {
    //查询用户列表
    public List<Role> getRoleList(Connection conn) throws SQLException;
}
