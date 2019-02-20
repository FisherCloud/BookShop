package com.winnercamp.dao;

import com.winnercamp.pojo.Cart;

import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : 2019/2/20
 * @time : 22:05
 */
public interface CartDao {
    /**
     * 保存购物车数据
     *
     * @param cart : 购物车对象
     * @return
     */
    Boolean save(Cart cart);


    /**
     * 通过会员id 查询购物车数据
     *
     * @param memberId : 会员id
     * @return
     */
    List<Cart> findAllByCartMemberId(Integer memberId);


    /**
     * 通过相应的ids查询购物车
     *
     * @param goodsId     : 商品ID
     * @param memberId    : 会员ID
     * @param orderStatus : 订单状态
     * @return
     */
    Cart findByGoodsMemberOrder(Integer goodsId, Integer memberId, Integer orderStatus);


    /**
     * 更新操作
     *
     * @param cart
     * @return
     */
    Boolean update(Cart cart);
}
