package com.Slzr.dao.user;

import com.Slzr.dao.BaseDao;
import com.Slzr.entity.User;
import com.Slzr.util.DbPool;
import com.Slzr.util.GetResultSetEntity;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        int execute=0;
        if(conn!=null){
            String sql="update smbms_user set userPassword = ? where id = ?";
            Object  parms[]={pwd,id};//注意sql 顺序
            execute=   BaseDao.excute(sql,parms,conn,ps);
        }

        return execute;
    }

    @Override
    public int getUserCount(Connection conn, String username, int rolecode,int pageNo,int pageSize) throws SQLException, Exception{
        StringBuffer sql=null;//创建字符缓存 为拼接sql命令
       PreparedStatement pstm= null;
        ResultSet rs= null;
        List<Object> list=new ArrayList<>();//创建列表添加参数为转换object[]
        if(conn!=null){
            sql=new StringBuffer();
            sql.append("select smbms_user.*,smbms_role.roleName as userRoleName from smbms_user,smbms_role where smbms_user.userRole=smbms_role.id");
            if(!StringUtils.isNullOrEmpty(username)) {
            sql.append("and smbms_user.userName like ?");//查找用户名称
            list.add("%"+username+"%");//%模糊查询
            }
            if(rolecode>0) {
                sql.append("and smbms_user.userRole= ?");//查找权限
                list.add(rolecode);
            }
            sql.append(" order by creationDate desc limit ?,?");//sql分页
            pageNo=(pageNo-1)*pageSize;
            list.add(pageNo );//起始第几个
            list.add(pageSize);//往后查的个数
        Object parms[]=list.toArray();
       rs= BaseDao.excute(sql.toString(),parms,conn,pstm,rs);
       GetResultSetEntity getusercount=new GetResultSetEntity();
        User user=new User();
       user= getusercount.SetUser(user,rs);

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
