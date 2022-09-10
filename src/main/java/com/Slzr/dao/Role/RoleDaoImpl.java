package com.Slzr.dao.Role;

import com.Slzr.dao.BaseDao;
import com.Slzr.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{
    @Override
    public List<Role> getRoleList(Connection conn) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Role> roleList=new ArrayList<>();
        if(conn!=null){
            String sql="select * from smbms_role";
            Object[] param={};
            rs= BaseDao.excute(sql,param,conn,pstm,rs);
        }

        while(rs.next()){
            Role role=new Role();
            role.setId(rs.getInt("id"));
            role.setRoleCode(rs.getString("roleCode"));
            role.setRoleName(rs.getString("roleName"));
            role.setCreatedBy(rs.getInt("createdBy"));
            role.setCreationDate(rs.getDate("creationDate"));
            role.setModifyBy(rs.getInt("modifyBy"));
            role.setModifyDate(rs.getDate("modifyDate"));
            roleList.add(role);
        }
        BaseDao.closeResource(null,pstm,rs);
        return roleList;
    }
}
