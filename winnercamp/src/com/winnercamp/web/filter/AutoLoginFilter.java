package com.dly.web.filter;

import com.dly.pojo.Member;
import com.dly.service.MemberService;
import com.dly.service.impl.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;

        String username = null;

        Cookie[] cookies = request.getCookies();

        String autoLogin = null;
        if(cookies != null) {
            for (Cookie c : cookies) {
                if ("autoLogin".equals(c.getName())) {
                    autoLogin = c.getValue();
                }
                if ("username".equals(c.getName())) {
                    username = c.getValue();
                }
            }
        }

        if("true".equals(autoLogin) && username != null){

            HttpSession session = request.getSession();

            MemberService service = new MemberServiceImpl();

            Member member = service.LoginByNikname(username);

            if(member != null){
                session.setAttribute("username",member.getMember_nikname());
                session.setAttribute("pwd",member.getMember_pwd());
            }

        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
