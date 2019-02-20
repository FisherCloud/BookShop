package com.winnercamp.web.controller;

import com.winnercamp.dto.BaseDto;
import com.winnercamp.pojo.Member;
import com.winnercamp.service.MemberService;
import com.winnercamp.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:45
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.action"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 获取相应的数据
        String member_nikname = request.getParameter("member_nikname");
        String member_pwd = request.getParameter("member_pwd");

        // 2. 组装一个member的对象
        Member member = new Member();
        member.setMember_nikname(member_nikname);
        member.setMember_pwd(member_pwd);

        // 3. 调用service
        MemberService ms = new MemberServiceImpl();

        BaseDto<Member> login = ms.login(member);

        // 4. 判断是否登陆成功? 登陆成功我们需要讲member对象保存到session
        request.setAttribute("msg", login.getMsg());
        if (login.getCode() == 200) {
            // 4.1 将memeber对象保存到session
            request.getSession().setAttribute("member", login.getData());
            // 4.2 跳转到正确的页面
            request.getRequestDispatcher("/pages/lgoinSuccess.jsp").forward(request, response);

        } else {
            // 4.3 跳转到错误的提示页面
            request.getRequestDispatcher("/pages/loginFailed.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 注销的思路:
         * 将之前保存的member设置未null
         */

        request.getSession().setAttribute("member", null);

        // 重定向到首页
        response.sendRedirect("/index.jsp");

    }
}
