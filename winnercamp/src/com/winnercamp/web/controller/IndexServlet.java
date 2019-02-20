package com.winnercamp.web.controller;

import com.winnercamp.pojo.Category;
import com.winnercamp.pojo.Goods;
import com.winnercamp.service.CategoryService;
import com.winnercamp.service.GoodsService;
import com.winnercamp.service.impl.CategoryServiceImpl;
import com.winnercamp.service.impl.GoodsServiceImpl;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:39
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/index.action"})
public class IndexServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        /**
         * ==========处理分类=============
         */
        // 调用service
        CategoryService cs = new CategoryServiceImpl();

        // 拿到分类的列表
        List<Category> categories = cs.getList();

        // 把数据存放到 request域对象
        request.setAttribute("list", categories);

        /**
         * ==========处理推荐书籍=============
         */
        GoodsService gs = new GoodsServiceImpl();

        List<Goods> goodsRecommendList = gs.getRecommendList();

        request.setAttribute("recoList", goodsRecommendList);

        // 请求转发
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);

    }
}
