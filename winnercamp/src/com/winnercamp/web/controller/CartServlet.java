package com.winnercamp.web.controller;

import com.winnercamp.dto.BaseDto;
import com.winnercamp.pojo.Cart;
import com.winnercamp.pojo.Member;
import com.winnercamp.service.CartService;
import com.winnercamp.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:53
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart.action"})
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取goods_id
        String goods_id = request.getParameter("goods_id");
        // 获取member_id
        Member member = (Member) request.getSession().getAttribute("member");
        // 构建cart对象
        Cart cart = new Cart();
        cart.setCart_goods_id(Integer.valueOf(goods_id));
        cart.setCart_member_id(member.getMember_id());

        // 调用service
        CartService cartService = new CartServiceImpl();
        BaseDto<Cart> cartBaseDto = cartService.addCart(cart);

        request.setAttribute("msg", cartBaseDto.getMsg());
        if (cartBaseDto.getCode() == 200) {
            request.getRequestDispatcher("/pages/cartSuccess.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/cartFailed.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
