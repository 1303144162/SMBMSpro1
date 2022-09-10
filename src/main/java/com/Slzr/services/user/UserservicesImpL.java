package com.Slzr.services.user;

import com.Slzr.dao.BaseDao;
import com.Slzr.dao.user.UserDao;
import com.Slzr.dao.user.UserDaoImpl;
import com.Slzr.entity.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserservicesImpL implements Userservices{
    //引用Dao层
    private UserDao userdao;
    public UserservicesImpL(){
        userdao=new UserDaoImpl();//构造方法创建userdao对象
    }
    @Override
    public User LoginUser(String usercode, String pwd) {
        Connection c=null;
        User user=null;
        c= BaseDao.getconnect();
       user= userdao.getUserCodeEnt(c,usercode);
        System.out.println(user.toString());
        BaseDao.closeResource(c,null,null);
        if(null != user.getId()){
            if(!user.getUserPassword().equals(pwd))
                user = null;
        }

        return user;

    }

    @Override
    public boolean updatePwd(int id, String pwd) {
        Connection conn=BaseDao.getconnect();
        boolean flag=false;
        try {
            if(userdao.updatePwd(conn,id,pwd)>0){
                flag=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(conn,null,null);
        }
        return flag;
    }

    @Override
    public int getUserCount(String username, int userrole) {
        Connection conn=null;
        int count=0;

        try {
            conn=BaseDao.getconnect();
         count= userdao.getUserCount(conn,username,userrole);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResource(conn,null,null);
        }

        return count;
    }

    @Override
    public List<User> getListUser(String username, int rolecode, int pageNo, int pageSize) throws SQLException, Exception {
       Connection conn= BaseDao.getconnect();
       List<User> userList=new ArrayList<User>();
        if (conn!=null){
            userList=userdao.getListUser(conn,username,rolecode,pageNo,pageSize);
        }
        BaseDao.closeResource(conn,null,null);
        return userList;
    }

    @Test
    public void test(){
//        Userservices userlogin=new UserservicesImpL();
//
//        User user=userlogin.LoginUser("test","1111");
//        if(user!=null){
//        System.out.println(user.getUserPassword());}

        System.out.println(getUserCount(null,1));
    }
}
