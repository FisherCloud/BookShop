package com.winnercamp.service;

import com.winnercamp.dto.BaseDto;
import com.winnercamp.pojo.Cart;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:29
 */
public interface CartService {

    /**
     * 添加购物车数据
     *
     * @param cart : 购物车对象
     * @return
     */
    BaseDto<Cart> addCart(Cart cart);

}
