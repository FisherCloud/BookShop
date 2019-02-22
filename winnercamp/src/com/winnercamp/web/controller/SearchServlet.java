package com.dly.web.contorller;

import com.dly.pojo.Category;
import com.dly.pojo.Goods;
import com.dly.service.CategoryService;
import com.dly.service.GoodsService;
import com.dly.service.impl.CategoryServiceimpl;
import com.dly.service.impl.GoodsServiceImpl;
import com.dly.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //header分类
        CategoryService service = new CategoryServiceimpl();

        List<Category> categorys = service.getList();

        request.setAttribute("categorys",categorys);



        //搜索处理
        String pageStr = request.getParameter("nowPage");
        String searchName = request.getParameter("searchName");

        Integer nowPage = pageStr == null ? 1 : Integer.valueOf(pageStr);
        PageUtil<Goods> pageUtil = new PageUtil<>();

        pageUtil.setNowPage(nowPage);
        pageUtil.setPageSize(12);

        GoodsService goodsService = new GoodsServiceImpl();
        goodsService.getSearchList(pageUtil,searchName);

        request.setAttribute("searchName",searchName);
        request.setAttribute("pageUtil",pageUtil);

        request.getRequestDispatcher("pages/search.jsp").forward(request,response);
    }
}
