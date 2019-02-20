package com.winnercamp.web.controller;

import com.winnercamp.pojo.Category;
import com.winnercamp.pojo.Goods;
import com.winnercamp.service.CategoryService;
import com.winnercamp.service.GoodsService;
import com.winnercamp.service.impl.CategoryServiceImpl;
import com.winnercamp.service.impl.GoodsServiceImpl;
import com.winnercamp.utils.PageUtil;

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
 * @time : 22:49
 */
@WebServlet(name = "BookListServlet", urlPatterns = {"/booklist.action"})
public class BookListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 需要去获取 category_id
        String id = request.getParameter("id");
        Integer category_id = Integer.valueOf(id);
        // 获取当前的页数
        String pageStr = request.getParameter("page");
        Integer page = pageStr == null ? 1 : Integer.valueOf(pageStr);
        Integer pageSize = 12;

        // 调用service 获取数据
        GoodsService gs = new GoodsServiceImpl();

        //List<Goods> categoryList = gs.getCategoryList(category_id);

        // 构造pageUtil对象
        PageUtil<Goods> pageUtil = new PageUtil<>();
        pageUtil.setNowPage(page);
        pageUtil.setPageSize(pageSize);

        gs.getCategoryList(pageUtil, category_id);


        request.setAttribute("pageUtil", pageUtil);


        /**
         * ==========处理分类=============
         */
        // 调用service
        CategoryService cs = new CategoryServiceImpl();

        // 拿到分类的列表
        List<Category> categories = cs.getList();

        // 把数据存放到 request域对象
        request.setAttribute("list", categories);


        // 数据转发
        request.getRequestDispatcher("/pages/bookList.jsp").forward(request, response);

    }
}
