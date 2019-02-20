package com.winnercamp.service.impl;

import com.winnercamp.dao.CartDao;
import com.winnercamp.dao.impl.CartDaoImpl;
import com.winnercamp.dto.BaseDto;
import com.winnercamp.pojo.Cart;
import com.winnercamp.service.CartService;
import com.winnercamp.utils.TimeUtil;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:30
 */
public class CartServiceImpl implements CartService {

    private CartDao cd = new CartDaoImpl();

    @Override
    public BaseDto<Cart> addCart(Cart cart) {
        // 验证member_id
        if (cart.getCart_member_id() <= 0 || cart.getCart_member_id() == null) {
            return new BaseDto<>(400, "会员数据错误!", null);
        }

        // 进行数据填充
        cart.setCart_goods_count(1);
        cart.setCart_add_time((int) TimeUtil.getTimeStamp());
        cart.setCart_order_status(0);

        // 先查询数据库是否有相同的商品记录
        Cart dbCart = cd.findByGoodsMemberOrder(cart.getCart_goods_id(), cart.getCart_member_id(), 0);

        Boolean save = false;
        if (dbCart != null) {
            // 更新数据
            cart.setCart_id(dbCart.getCart_id());
            save = cd.update(cart);
        } else {
            // 直接添加
            save = cd.save(cart);
        }


        if (save) {
            return new BaseDto<>(200, "添加购物车成功", null);
        }

        return new BaseDto<>(400, "添加购物车失败", null);
    }

}
