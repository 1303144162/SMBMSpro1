package com.Slzr.util;

import com.Slzr.dao.BaseDao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class DbPool {
//连接池
    List<Connection> cs=new ArrayList<Connection>();
     int size=5;
    String drive=null;
    String url=null;
    String dbuser=null;
    String password=null;
    private static volatile DbPool dbpool;
   private  DbPool(){

    }
   public static DbPool getDbPool() throws SQLException, IOException, ClassNotFoundException {
    if(dbpool==null){//单例模式只获取一个对象
        dbpool=new DbPool();
        dbpool.init();//初始化
    }
    return dbpool;
    }
    private   void init() throws IOException, ClassNotFoundException, SQLException {
        //获取properties文件数据
        InputStream resourceAsStream = DbPool.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(resourceAsStream);
        drive= properties.getProperty("drive");
        url=properties.getProperty("url");
        dbuser= properties.getProperty("dbuser");
        password=properties.getProperty("password");

       String value=null;
       value=(String) properties.get("size");//判断properties文件有没有设置连接数
      if(value!=null) this.size=Integer.parseInt(value);

        //加载sql驱动
        Class.forName(drive);
        //创建连接池
        for (int i = 0; i < size; i++) {
            Connection c=DriverManager.getConnection(url,dbuser,password);
            System.out.println("创建第"+(i+1)+"个连接");
            cs.add(c);
        }

    }
    //synchronized 线程安全性
    public synchronized Connection getConnect(){
        try {
        while(cs.isEmpty()){//判断连接池是否为空如果为空则等待
                this.wait();
        }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //移除第一个连接池
        Connection c=cs.remove(0);
        return c;
    }
    public synchronized void returnConnect(Connection c){
       // 使用完给回连接池中唤醒wait告诉它有新的连接池可用
        cs.add(c);
        this.notifyAll();
    }

}
