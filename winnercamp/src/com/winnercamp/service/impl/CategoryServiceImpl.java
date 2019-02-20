package com.winnercamp.service.impl;

import com.winnercamp.dao.CategoryDao;
import com.winnercamp.dao.impl.CategoryDaoImpl;
import com.winnercamp.pojo.Category;
import com.winnercamp.service.CategoryService;

import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:28
 */
public class CategoryServiceImpl implements CategoryService {

    /**
     * 分类的数据访问对象
     */
    private CategoryDao cd = new CategoryDaoImpl();


    /**
     * 获取分类的列表
     *
     * @return
     */
    @Override
    public List<Category> getList() {
        // 数据的验证
        List<Category> all = cd.findAll();
        return all;
    }

}
