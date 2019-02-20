package com.winnercamp.dao;

import com.winnercamp.pojo.Goods;

import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : 2019/2/20
 * @time : 22:05
 */
public interface GoodsDao {


    /**
     * 推荐书籍的列表
     *
     * @return
     */
    List<Goods> listRecommend();


    /**
     * 分类列表
     *
     * @param category_id : 分类id
     * @return
     */
    List<Goods> listCategory(Integer category_id);

    /**
     * 分页的分类列表
     *
     * @param category_id : 分类id
     * @param page        : 当前页
     * @param pageSize    : 页容量
     * @return
     */
    List<Goods> listCategory(Integer category_id, Integer page, Integer pageSize);


    /**
     * 通过主键id去查询书籍
     *
     * @param id : 主键id
     * @return
     */
    Goods findById(Integer id);


    /**
     * 获取当前分类下所有的条数
     *
     * @param category_id : 分类id
     * @return
     */
    Integer getTotalCount(Integer category_id);
}
