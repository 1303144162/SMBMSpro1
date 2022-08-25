package com.Slzr.dao;

import com.Slzr.util.DbPool;

import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String drive;
    private static String url;
    private static String dbuser;
    private static String password;

    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");//通过类加载器读取资源
      //  DruidDataSource ds=new DruidDataSource(); //连接池
       // ds.getConnection()
      //  DruidDataSourceFactory.createDataSource(properties);

        try {
         properties.load(resourceAsStream);
        drive= properties.getProperty("drive");
        url=  properties.getProperty("url");
        dbuser= properties.getProperty("dbuser");
        password=properties.getProperty("password");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    public static Connection getconnect()  {
        Connection conn=null;
        try {
            Class.forName(drive);

        conn = DriverManager.getConnection(url, dbuser, password);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return conn;

    }
    public static ResultSet excute(String sql, Object[] parmes, Connection c, PreparedStatement ps, ResultSet rs) throws SQLException {
        ps = c.prepareStatement(sql);
        for(int i = 0; i < parmes.length; i++) {
            ps.setObject(i + 1, parmes[i]);
        }
        rs = ps.executeQuery();
        return rs;
    }
    public static int excute(String sql, Object[] parmes, Connection c, PreparedStatement ps) throws SQLException {
        ps = c.prepareStatement(sql);
        int i;
        for(i = 0; i < parmes.length; i++) {
            ps.setObject(i + 1, parmes[i]);
        }
        i = ps.executeUpdate();
        return i;
    }
    public static boolean closeResource(Connection c, PreparedStatement ps, ResultSet rs) {
        boolean flag = true;
        try {
            if (rs != null) {
                rs.close(); rs = null;
            } if (ps != null) {
                ps.close(); ps = null;
            }
            if (c != null) {
                c.close(); c = null;
            }

        } catch (SQLException var5) {
            flag = false; throw new RuntimeException(var5);

        }
        return flag;
    }
    @Test
    public void test() throws SQLException, IOException, ClassNotFoundException {
        DbPool db=DbPool.getDbPool();
        Connection c= db.getConnect();
        Statement st= c.createStatement();
        boolean resultSet = st.execute("select * from Smbms_user");
        if(resultSet){
            System.out.println("获取成功");
        }
        st.close();
        db.returnConnect(c);
    }

}
