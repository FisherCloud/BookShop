package com.winnercamp.service;

import com.winnercamp.pojo.Goods;
import com.winnercamp.utils.PageUtil;

import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:31
 */
public interface GoodsService {

    /**
     * 推荐书籍列表
     *
     * @return
     */
    List<Goods> getRecommendList();


    /**
     * 查询分类列表
     *
     * @param category_id : 分类id
     * @return
     */
    List<Goods> getCategoryList(Integer category_id);


    /**
     * 查询分页分类列表
     *
     * @param pageUtil    : 分页类对象
     * @param category_id : 分类id
     */
    void getCategoryList(PageUtil<Goods> pageUtil, Integer category_id);


    /**
     * 书籍详情
     *
     * @param id
     * @return
     */
    Goods detail(Integer id);
}
