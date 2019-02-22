package com.dly.web.contorller;

import com.dly.utils.VerifyCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerifyCodeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtil.generateVerifyCode(4);

        System.out.println(verifyCode);

        //存入会话session
        req.getSession().setAttribute("CODE", verifyCode.toLowerCase());

        //生成图片
        int width = 100;//宽
        int height = 40;//高
        VerifyCodeUtil.outputImage(width, height, resp.getOutputStream(), verifyCode);

    }
}
