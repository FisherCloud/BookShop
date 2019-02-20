package com.winnercamp.dao;

import com.winnercamp.pojo.Member;

/**
 * @author : 鱼摆摆
 * @date : 2019/2/20
 * @time : 22:06
 */
public interface MemberDao {
    /**
     * 通过用户名和密码进行查询
     *
     * @param memberName
     * @param pwd
     * @return
     */
    Member findByNameAndPwd(String memberName, String pwd);

    /**
     * 通过用户名来进行查询
     *
     * @param memberName
     * @return
     */
    Member findByName(String memberName);
}
