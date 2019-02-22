package com.dly.web.contorller;

import com.dly.dto.RegisterDto;
import com.dly.pojo.Member;
import com.dly.service.MemberService;
import com.dly.service.impl.MemberServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String verifyCode = request.getParameter("validateCode");
        String code = request.getSession().getAttribute("CODE").toString().toLowerCase();
        if (code.equals(verifyCode)) {
            String member_nikName = request.getParameter("username");
            String member_pwd = request.getParameter("password");
            String member_email = request.getParameter("email");
            String member_name = request.getParameter("name");
            String member_phone = request.getParameter("telephone");

            Map<String, Object> map = new HashMap<>();
            map.put("member_nikname", member_nikName);
            map.put("member_pwd", member_pwd);
            map.put("member_email", member_email);
            map.put("member_name", member_name);
            map.put("member_phone", Integer.valueOf(member_phone));

            Member member = new Member();

            try {
                BeanUtils.populate(member, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            MemberService service = new MemberServiceImpl();

            response.getWriter().write(service.addMember(member).getCode_statu() + "");

        } else {
            RegisterDto registerDto = new RegisterDto();

            registerDto.setCode_statu(0);

            response.getWriter().write(registerDto.getCode_statu() + "");
        }

    }
}
