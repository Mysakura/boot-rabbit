package com.example.demo.response;

import java.io.Serializable;

/**
 * @program: boot-rabbitmq
 * @description:
 * @author: 001977
 * @create: 2018-07-03 15:35
 */
public class RabbitResponse implements Serializable {

    private Integer code;
    private String msg;

    public RabbitResponse() {
        this(0,"success");
    }

    public RabbitResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
