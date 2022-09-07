package com.Slzr.dao.user;

import com.Slzr.dao.BaseDao;
import com.Slzr.entity.User;
import com.Slzr.util.DbPool;
import com.Slzr.util.GetResultSetEntity;
import org.junit.Test;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    public User getUserCodeEnt(Connection c, String Usercode) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        User user = null;

        if (c != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] o = {Usercode};
            try {
                rs = BaseDao.excute(sql, o, c, ps, rs);
                user = new User();
                GetResultSetEntity gsu = new GetResultSetEntity();
                user = gsu.SetUser(user, rs);//利用反射获取方法判断字段属性给user类赋值


//            if(rs.next()) {
//                //user.setId( rs.getInt("id"));//传统方法获取
//            }

            } catch (Exception e) {
                //BaseDao.closeResource(null,ps,rs);
                e.printStackTrace();
            }
        }
        BaseDao.closeResource(null,ps,rs);

        return user;
    }

    @Override
    public int updatePwd(Connection conn, int id, String pwd) throws SQLException {

        PreparedStatement ps = null;

        if(conn!=null){
            String sql="update smbms_user set userPassword = ? where id = ?";
            Object  parms[]={pwd,id};//注意sql 顺序
            return   BaseDao.excute(sql,parms,conn,ps);
        }

        return 0;
    }


    @Test
    public void test() throws SQLException, IOException, ClassNotFoundException {
      DbPool db=  DbPool.getDbPool();
      Connection c=db.getConnect();
      UserDaoImpl udi=new UserDaoImpl();
      udi.getUserCodeEnt(c,"admin");

    }
}
