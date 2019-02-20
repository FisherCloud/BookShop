package com.winnercamp.dao.impl;

import com.winnercamp.dao.MemberDao;
import com.winnercamp.pojo.Member;
import com.winnercamp.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author : 鱼摆摆
 * @date : 2019/2/20
 * @time : 22:07
 */
public class MemberDaoImpl implements MemberDao {
    private QueryRunner runner = new QueryRunner(DruidUtil.getDataSource());

    @Override
    public Member findByNameAndPwd(String memberName, String pwd) {

        /**
         * 用户登陆:
         * 用户名错了: 提示没有该用户
         * 用户密码错了: 密码错误
         * 用户没有验证: 未验证
         *
         *
         * 先通过用户名去查询,没有数据,有数据: 对比密码
         */


        return null;
    }

    @Override
    public Member findByName(String memberName) {

        String sql = "select * from member where member_nikname=? limit 1";

        Member query = null;
        try {
            query = runner.query(sql, new BeanHandler<>(Member.class), memberName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
