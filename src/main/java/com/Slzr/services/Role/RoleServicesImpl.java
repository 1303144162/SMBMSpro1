package com.Slzr.services.Role;

import com.Slzr.dao.BaseDao;
import com.Slzr.dao.Role.RoleDao;
import com.Slzr.dao.Role.RoleDaoImpl;
import com.Slzr.entity.Role;
import com.Slzr.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleServicesImpl implements RoleServices{
    private RoleDao roledao;
   public RoleServicesImpl(){
        roledao=new RoleDaoImpl();
    }
    @Override
    public List<Role> getRoleList() throws SQLException {
        List<Role> roleList =new ArrayList<>();
        Connection connection= BaseDao.getconnect();
        roleList= roledao.getRoleList(connection);
        BaseDao.closeResource(connection,null,null);
        return roleList;
    }
}
