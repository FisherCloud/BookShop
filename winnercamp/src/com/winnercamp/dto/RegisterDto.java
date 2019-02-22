package com.dly.dto;

public class RegisterDto {

    /**
     * 验证码的状态 0验证码错误 1注册成功 2数据库异常 3用户名重复
     */
    private int code_statu;

    public int getCode_statu() {
        return code_statu;
    }

    public void setCode_statu(int code_statu) {
        this.code_statu = code_statu;
    }
}
