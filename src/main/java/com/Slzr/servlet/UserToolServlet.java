package com.Slzr.servlet;

import com.Slzr.entity.User;
import com.Slzr.services.user.Userservices;
import com.Slzr.services.user.UserservicesImpL;
import com.Slzr.util.Constants;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import com.mysql.cj.xdevapi.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="UserToolServlet",value = "/jsp/user.do")
public class UserToolServlet extends HttpServlet {
    //复用方法和正常建立一个Servlet类的操作基本相同，不同点是原来在doGet类中写的具体逻辑代码写在了updatePwd类中，仅仅在doGet中调用这个方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String method=req.getParameter("method");
            if(method.equals("savepwd")&& method != null){
                this.savepwd(req,resp);
            }else if(method.equals("pwdmodify") && method != null){//隐藏域判断
                this.pwdmodify(req, resp);
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void pwdmodify(HttpServletRequest req,HttpServletResponse resp) throws IOException {//ajax判断原密码
        Object usersession= req.getSession().getAttribute(Constants.User_Session);//获取session
       String  oldpassword=req.getParameter("oldpassword");//获取密码

        Map<String, String> resultMap = new HashMap<String, String>();//map集合
            String userpwd=((User)usersession).getUserPassword();//Session中用户的密码
            if(userpwd.equals(oldpassword)) {
                resultMap.put("result", "true");
            }else{
                resultMap.put("result","false");

        }
        resp.setContentType("application/json");
        PrintWriter pw=resp.getWriter();
        //把resultMap保存的键值对转换为json格式的键值对
        pw.write(JSONArray.toJSONString(resultMap));
        pw.flush();
        pw.close();
    }
    public void savepwd(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        Object usersession= req.getSession().getAttribute(Constants.User_Session);
        String pwd=  req.getParameter("newpassword");
        boolean flag=false;
        if(usersession!=null && !StringUtils.isNullOrEmpty(pwd)){
            Userservices userservices=new UserservicesImpL();
            flag= userservices.updatePwd(((User)usersession).getId(),pwd);
            if (flag){
                req.setAttribute("message","密码修改成功");
                req.getSession().removeAttribute(Constants.User_Session);
            }else {
                req.setAttribute("message","密码修改失败");
            }
        }else{
            req.setAttribute("message","密码修改有问题");
        }
        req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
    }
}
