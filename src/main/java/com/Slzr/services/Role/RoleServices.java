package com.Slzr.services.Role;

import com.Slzr.entity.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoleServices {
    public List<Role> getRoleList() throws SQLException;
}
