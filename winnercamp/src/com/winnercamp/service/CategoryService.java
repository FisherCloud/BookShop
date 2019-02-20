package com.winnercamp.service;

import com.winnercamp.pojo.Category;

import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:27
 */
public interface CategoryService {

    /**
     * 获取分类的列表
     *
     * @return
     */
    List<Category> getList();

}
