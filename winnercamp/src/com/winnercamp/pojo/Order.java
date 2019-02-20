package com.winnercamp.pojo;

/**
 * @author : 鱼摆摆
 * @date : Create at 2019/2/20
 * @time : 22:15
 */
public class Order {

    private int order_id;
    private String order_code;
    /**
     * 收货人地址类
     */
    private String order_email;
    /**
     * 收货人姓名类
     */
    private String order_user_name;
    /**
     * 订单支付状态
     */
    private int order_pay_status;
    /**
     * 订单总金额
     */
    private int order_total_price;
    /**
     * 订单添加时间
     */
    private int order_add_time;
    /**
     * 订单会员id
     */
    private int order_member_id;

    public Order() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getOrder_email() {
        return order_email;
    }

    public void setOrder_email(String order_email) {
        this.order_email = order_email;
    }

    public String getOrder_user_name() {
        return order_user_name;
    }

    public void setOrder_user_name(String order_user_name) {
        this.order_user_name = order_user_name;
    }

    public int getOrder_pay_status() {
        return order_pay_status;
    }

    public void setOrder_pay_status(int order_pay_status) {
        this.order_pay_status = order_pay_status;
    }

    public int getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(int order_total_price) {
        this.order_total_price = order_total_price;
    }

    public int getOrder_add_time() {
        return order_add_time;
    }

    public void setOrder_add_time(int order_add_time) {
        this.order_add_time = order_add_time;
    }

    public int getOrder_member_id() {
        return order_member_id;
    }

    public void setOrder_member_id(int order_member_id) {
        this.order_member_id = order_member_id;
    }

    @Override
    public String toString() {
        return "order{" +
                "order_id=" + order_id +
                ", order_code='" + order_code + '\'' +
                ", order_email='" + order_email + '\'' +
                ", order_user_name='" + order_user_name + '\'' +
                ", order_pay_status=" + order_pay_status +
                ", order_total_price=" + order_total_price +
                ", order_add_time=" + order_add_time +
                ", order_member_id=" + order_member_id +
                '}';
    }
}
