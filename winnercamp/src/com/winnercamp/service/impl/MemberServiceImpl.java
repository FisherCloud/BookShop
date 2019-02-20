package com.winnercamp.service.impl;

import com.winnercamp.dao.MemberDao;
import com.winnercamp.dao.impl.MemberDaoImpl;
import com.winnercamp.dto.BaseDto;
import com.winnercamp.pojo.Member;
import com.winnercamp.service.MemberService;
import com.winnercamp.utils.MD5Util;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:33
 */
public class MemberServiceImpl implements MemberService {

    private MemberDao md = new MemberDaoImpl();

    @Override
    public BaseDto<Member> login(Member member) {
        /**
         * 用户登陆:
         * 用户名错了: 提示没有该用户
         * 用户密码错了: 密码错误
         * 用户没有验证: 未验证
         *
         *
         * 先通过用户名去查询,没有数据,有数据: 对比密码
         */
        // 1. 数据验证
        if (member.getMember_nikname() == null || member.getMember_nikname().isEmpty()) {
            return new BaseDto<>(400, "用户名不能为空!", null);
        }
        if (member.getMember_pwd() == null || member.getMember_pwd().isEmpty()) {
            return new BaseDto<>(400, "用户密码不能为空!", null);
        }

        //2. 再去查询数据库
        Member dbMember = md.findByName(member.getMember_nikname());
        if (dbMember == null) {
            return new BaseDto<>(400, "该用户不存在!", dbMember);
        }

        //3. 进行密码的验证
        if (!MD5Util.MD55(member.getMember_pwd()).equals(dbMember.getMember_pwd())) {
            return new BaseDto<>(400, "密码错误!", dbMember);
        }
        //4. 验证状态
        if (dbMember.getMember_status() != 1) {
            return new BaseDto<>(400, "用户未验证!", dbMember);
        }

        // 5. 登陆成功
        return new BaseDto<>(200, "登陆成功!", dbMember);
    }

}
