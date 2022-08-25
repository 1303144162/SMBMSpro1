package com.Slzr.services.user;

import com.Slzr.dao.BaseDao;
import com.Slzr.dao.user.UserDao;
import com.Slzr.dao.user.UserDaoImpl;
import com.Slzr.entity.User;
import org.junit.Test;

import java.sql.Connection;

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
    @Test
    public void test(){
        Userservices userlogin=new UserservicesImpL();

        User user=userlogin.LoginUser("test","1111");
        if(user!=null){
        System.out.println(user.getUserPassword());}
    }
}
