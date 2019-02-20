package com.winnercamp.dao;

import com.winnercamp.pojo.Category;

import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : 2019/2/20
 * @time : 22:05
 */
public interface CategoryDao {

    /**
     * 查询所有的方法
     *
     * @return
     */
    List<Category> findAll();

}
