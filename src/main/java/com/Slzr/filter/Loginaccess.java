package com.Slzr.filter;

import com.Slzr.entity.User;
import com.Slzr.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Loginaccess implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletResponse hresp=(HttpServletResponse)servletResponse;
        HttpServletRequest hreq=(HttpServletRequest)servletRequest;
        User user=(User)hreq.getSession().getAttribute(Constants.User_Session);


        if(user==null) {
            hresp.sendRedirect(hreq.getContextPath() + "/error.jsp");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
