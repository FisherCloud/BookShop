package com.winnercamp.dao.impl;

import com.winnercamp.dao.GoodsDao;
import com.winnercamp.pojo.Category;
import com.winnercamp.pojo.Goods;
import com.winnercamp.utils.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author : 鱼摆摆
 * @date : 2019/2/20
 * @time : 22:07
 */
public class GoodsDaoImpl implements GoodsDao {

    private QueryRunner runner = new QueryRunner(DruidUtil.getDataSource());

    @Override
    public List<Goods> listRecommend() {

        String sql = "select * from goods order by goods_id desc limit 12";

        List<Goods> query = null;
        try {
            query = runner.query(sql, new BeanListHandler<>(Goods.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    @Override
    public List<Goods> listCategory(Integer category_id) {

        // 准备查询sql
        String sql = "select * from goods where goods_category_id=?";

        List<Goods> query = null;
        try {
            query = runner.query(sql, new BeanListHandler<>(Goods.class), category_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    @Override
    public List<Goods> listCategory(Integer category_id, Integer page, Integer pageSize) {
        // 准备查询sql
        String sql = "select * from goods where goods_category_id=? limit ?,?";

        List<Goods> query = null;
        try {
            query = runner.query(sql, new BeanListHandler<>(Goods.class), category_id, (page - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }


    @Override
    public Goods findById(Integer id) {

        String sql = "SELECT g.*,c.category_name FROM goods g LEFT JOIN category c ON g.goods_category_id=c.category_id where g.goods_id=?";

        Goods query = null;
        try {
            //query = runner.query(sql, new BeanHandler<>(Goods.class), id);
            Map<String, Object> dataMap = runner.query(sql, new MapHandler(), id);

            /**
             * 将map转换成goods
             * 将map转换成category
             */

            Goods goods = new Goods();
            Category category = new Category();
            BeanUtils.populate(goods, dataMap);
            BeanUtils.populate(category, dataMap);

            // 将category设置到goods里面
            goods.setCategory(category);
            query = goods;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public Integer getTotalCount(Integer category_id) {

        String sql = "select count(1) from goods where goods_category_id=?";

        Long query = null;
        try {
            query = runner.query(sql, new ScalarHandler<>(), category_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return Integer.valueOf(query.toString());
    }
}
