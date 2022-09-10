package com.Slzr.util;

import com.Slzr.dao.BaseDao;
import com.Slzr.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

public class GetResultSetEntity {
    public User SetUser(User s,ResultSet rs) throws ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Class userclass = Class.forName("com.Slzr.entity.User");//使用反射获取class内容
        Field[] fields = userclass.getDeclaredFields();//获取class的字段属性
        ResultSetMetaData rsdata = rs.getMetaData();//获取resultset的列名称和类型信息
        int count = rsdata.getColumnCount();//获取resultset的列表列数


        for (int i = 1; i <= count; i++) {
            String name = rsdata.getColumnName(i);//获取列名
            for (Field f : fields) {
                if (name.equals(f.getName())) {//判断属性名称和数据库字段名称是否相同
                    Method method = null;//提取方法
                    String type = f.getGenericType().toString();//获取属性类型

                    //判断User类属性 并进行赋值
                    if ("class java.lang.Integer".equals(type)) {

                        method = userclass.getMethod("set" + f.getName().substring(0, 1).toUpperCase() + name.substring(1), Integer.class);
                        method.invoke(s, rs.getInt(name));//set首字母大写
                    }

                    if (type.equals("class java.lang.String")) {

                        method = userclass.getMethod("set" + f.getName().substring(0, 1).toUpperCase() + name.substring(1), String.class);
                        method.invoke(s, rs.getString(i));
                    }
                    if (type.equals("class java.util.Date")) {

                        method = userclass.getMethod("set" + f.getName().substring(0, 1).toUpperCase() + name.substring(1), Date.class);
                        method.invoke(s, rs.getDate(i));
                    }
                }
            }
           // System.out.println(s.getId());

    }
        return s;
    }
}
