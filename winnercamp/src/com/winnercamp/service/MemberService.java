package com.winnercamp.service;

import com.winnercamp.dto.BaseDto;
import com.winnercamp.pojo.Member;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:33
 */
public interface MemberService {

    /**
     * 登陆的方法
     *
     * @param member
     * @return
     */
    BaseDto<Member> login(Member member);

}
