package com.winnercamp.dao.impl;

import com.winnercamp.dao.CartDao;
import com.winnercamp.pojo.Cart;
import com.winnercamp.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : 2019/2/20
 * @time : 22:06
 */
public class CartDaoImpl implements CartDao {
    private QueryRunner runner = new QueryRunner(DruidUtil.getDataSource());


    @Override
    public Boolean save(Cart cart) {

        String sql = "insert into cart (cart_goods_id,cart_member_id, cart_goods_count, cart_add_time, cart_order_status, cart_order_code) values (?,?,?,?,?,?)";

        int effectRows = 0;
        try {
            effectRows = runner.execute(sql, cart.getCart_goods_id(), cart.getCart_member_id(), cart.getCart_goods_count(), cart.getCart_add_time(), cart.getCart_order_status(), "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return effectRows > 0 ? true : false;
    }

    @Override
    public List<Cart> findAllByCartMemberId(Integer memberId) {


        return null;
    }

    @Override
    public Cart findByGoodsMemberOrder(Integer goodsId, Integer memberId, Integer orderStatus) {

        String sql = "select * from cart where cart_goods_id=? and cart_member_id=? and cart_order_status=?";
        Cart query = null;
        try {
            query = runner.query(sql, new BeanHandler<>(Cart.class), goodsId, memberId, orderStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public Boolean update(Cart cart) {

        String sql = "update cart set cart_goods_count=cart_goods_count+1 where cart_id=?";

        int effectRows = 0;
        try {
            effectRows = runner.execute(sql, cart.getCart_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return effectRows > 0 ? true : false;
    }
}
