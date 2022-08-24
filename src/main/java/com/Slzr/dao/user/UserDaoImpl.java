package com.Slzr.dao.user;

import com.Slzr.dao.BaseDao;
import com.Slzr.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    public void getUserCode(Connection c, String Usercode) {
        ResultSet rs=null;
        PreparedStatement ps=null;
        User user=null;
        try {
        if(c!=null){
            String sql="select *from smbms_user where userCode=?";
            Object[] o={Usercode};
          rs=  BaseDao.excute(sql,o,c,ps,rs);
          if(rs.next()){
              user=new User();

          }
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
