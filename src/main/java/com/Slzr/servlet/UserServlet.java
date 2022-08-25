package com.Slzr.servlet;


import com.Slzr.entity.User;
import com.Slzr.services.user.Userservices;
import com.Slzr.services.user.UserservicesImpL;
import com.Slzr.util.Constants;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login",value = "/login.do")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //控制层
        Userservices loginuser=new UserservicesImpL();
        HttpSession session1=null;
        User user=null;
       String usercode=req.getParameter("userCode");
       String pwd= req.getParameter("userPassword");
        user= loginuser.LoginUser(usercode,pwd);
        if(user!=null){
           session1= req.getSession();
           session1.setAttribute(Constants.User_Session,user);
           //session1.setAttribute("userSession","user.getUserName().toString()");
            resp.sendRedirect(req.getContextPath()+"/jsp/frame.jsp");
        }else{
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }
}
