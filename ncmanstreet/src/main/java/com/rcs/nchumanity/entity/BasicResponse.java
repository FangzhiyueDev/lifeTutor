package com.rcs.nchumanity.entity;


import com.google.gson.Gson;

/**
 * 基本的响应模块的实现
 * <p>
 * 定义了基本的响应码和消息内容，
 * <p>
 * <p>
 * 请不要给该类修改枚举类型，在使用部分解析json库时，不能正常的序列化数据
 */
public class BasicResponse {


    public static final int ERROR = 0;

    /**
     * 没有这个用户
     * 也就是用户未注册
     */
    public static final int NOT_REGISTER = 0X001;

    /**
     * 用户被注册
     */
    public static final int REGISTED = 0x002;

    /**
     * 注册成功
     */
    public static final int REGISTED_SUCCESS = 0x003;

    /**
     * 登录成功
     */
    public static final int LOGIN_SUCCESS = 0x004;


    /**
     * code 代表的是响应码
     */
    public int code;

    /***
     * 消息提示
     */
    public String message;

    /**
     * 传输的数据对象
     */
    public Object data;

    public BasicResponse(int code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.data = object;
    }


}
