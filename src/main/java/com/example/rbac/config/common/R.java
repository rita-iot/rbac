package com.example.rbac.config.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @description: --
 * @author: Bing
 * @date: 2023/6/17 14:28
 * @version: 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
