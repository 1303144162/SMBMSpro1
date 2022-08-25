package com.Slzr.dao.user;

import com.Slzr.dao.BaseDao;
import com.Slzr.entity.User;
import com.Slzr.util.DbPool;
import com.Slzr.util.GetResultSetEntity;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
        if(c!=null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] o = {Usercode};
            rs = BaseDao.excute(sql, o, c, ps, rs);
            user = new User();
            GetResultSetEntity gsu=new GetResultSetEntity();
           user= gsu.SetUser(user,rs);
            System.out.println(user.toString());
//            if(rs.next()) {
//                //user.setId( rs.getInt("id"));
//            }


        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() throws SQLException, IOException, ClassNotFoundException {
      DbPool db=  DbPool.getDbPool();
      Connection c=db.getConnect();
      UserDaoImpl udi=new UserDaoImpl();
      udi.getUserCode(c,"admin");
    }
}
