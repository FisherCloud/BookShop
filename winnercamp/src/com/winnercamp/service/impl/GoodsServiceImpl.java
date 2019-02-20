package com.winnercamp.service.impl;

import com.winnercamp.dao.GoodsDao;
import com.winnercamp.dao.impl.GoodsDaoImpl;
import com.winnercamp.pojo.Goods;
import com.winnercamp.service.GoodsService;
import com.winnercamp.utils.PageUtil;

import java.util.List;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:31
 */
public class GoodsServiceImpl implements GoodsService {

    private GoodsDao gd = new GoodsDaoImpl();


    @Override
    public List<Goods> getRecommendList() {

        List<Goods> goods = gd.listRecommend();

        return goods;
    }

    @Override
    public List<Goods> getCategoryList(Integer category_id) {
        // 做数据验证
        if (category_id <= 0) {
            return null;
        }
        List<Goods> goods = gd.listCategory(category_id);

        return goods;
    }

    @Override
    public void getCategoryList(PageUtil<Goods> pageUtil, Integer category_id) {
        // 做数据验证
        if (category_id <= 0) {
            return;
        }

        // 获取分页的数据
        List<Goods> goods = gd.listCategory(category_id, pageUtil.getNowPage(), pageUtil.getPageSize());

        // 获取总的条数
        Integer totalCount = gd.getTotalCount(category_id);

        // 设置相应的值
        pageUtil.setTotalNums(totalCount);
        pageUtil.setContent(goods);
    }

    @Override
    public Goods detail(Integer id) {
        if (id <= 0 || id == null) {
            return null;
        }
        Goods byId = gd.findById(id);
        return byId;
    }

}
