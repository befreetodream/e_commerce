package com.cjy.e_commerce.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //传递信息

    private T data; //数据

    public static <Q> Result<Q> success(Q object) {
        Result<Q> r = new Result<Q>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static  Result ok() {
        Result r = new Result();
        r.code = 1;
        return r;
    }

    public static Result error(String msg) {
        Result r = new Result();
        r.msg = msg;
        r.code = 0;
        return r;
    }
}
