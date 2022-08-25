package com.Slzr.filter;

import com.Slzr.entity.User;
import com.Slzr.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Loginaccess implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletResponse hresp=(HttpServletResponse)servletResponse;
        HttpServletRequest hreq=(HttpServletRequest)servletRequest;
        User user=(User)hreq.getSession().getAttribute(Constants.User_Session);


        if(user!=null){
//            System.out.println(hreq.getContextPath().toString()+":"+hreq.getServletPath());
//            if(hreq.getServletPath().toString().equals(hreq.getContextPath()+"/login.jsp")) {
//                 hresp.sendRedirect(hreq.getContextPath()+"/jsp/frame.jsp");
//            }
        }else {
            hresp.sendRedirect(hreq.getContextPath()+"/error.jsp");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
