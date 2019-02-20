package com.winnercamp.dao.impl;

import com.winnercamp.dao.CategoryDao;
import com.winnercamp.pojo.Category;
import com.winnercamp.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : 2019/2/20
 * @time : 22:06
 */
public class CategoryDaoImpl implements CategoryDao {

    /**
     * sql 执行器
     */
    private QueryRunner runner = new QueryRunner(DruidUtil.getDataSource());

    /**
     * 查询所有分类
     * 写相关的sql语句
     *
     * @returnc
     */
    @Override
    public List<Category> findAll() {


        // 1. 准备sql语句
        String sql = "select * from category order by category_id asc limit 10";


        // 2. 执行sql
        List<Category> list = null;
        try {
            // 执行sql并处理结果
            list = runner.query(sql, new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
