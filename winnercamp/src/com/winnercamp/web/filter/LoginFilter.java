package com.winnercamp.web.filter;

import com.winnercamp.pojo.Member;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:54
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 放行前
        /**
         * 判断是否有session,有放行
         * 没有: 拦截
         *    跳转到指定的页面
         */

        // 1. 参数的强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 准备放行的url
        String urls = "/,/login.jsp,/index.action,/login.action";
        // 获取当前请求的url
        String requestURL = request.getRequestURL().toString();
        String url = requestURL.substring(requestURL.lastIndexOf("/"));

        if (urls.indexOf(url) == -1) {
            // 2. 获取session
            HttpSession session = request.getSession();

            // 3. 判断session是否有值
            Member member = (Member) session.getAttribute("member");


            if (member == null) {
                // 拦截到啦!
                response.sendRedirect("/pages/login.jsp");
                return;
            }
        }

        // 放行
        chain.doFilter(req, resp);


        // 放行后

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤被创建成功!");
    }

}
