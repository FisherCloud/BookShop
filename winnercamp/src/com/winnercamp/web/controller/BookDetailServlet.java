package com.winnercamp.web.controller;

import com.winnercamp.pojo.Category;
import com.winnercamp.pojo.Goods;
import com.winnercamp.service.CategoryService;
import com.winnercamp.service.GoodsService;
import com.winnercamp.service.impl.CategoryServiceImpl;
import com.winnercamp.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:51
 */
@WebServlet(name = "BookDetailServlet", urlPatterns = {"/detail.action"})
public class BookDetailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * ==========处理分类=============
         */
        // 调用service
        CategoryService cs = new CategoryServiceImpl();

        // 拿到分类的列表
        List<Category> categories = cs.getList();

        // 把数据存放到 request域对象
        request.setAttribute("list", categories);


        // 1 . 获取数据
        String id = request.getParameter("id");

        // 调用service
        GoodsService gs = new GoodsServiceImpl();

        Goods detail = gs.detail(Integer.valueOf(id));

        request.setAttribute("detail", detail);

        request.getRequestDispatcher("/pages/bookinfo.jsp").forward(request, response);


    }
}
