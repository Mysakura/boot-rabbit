package com.example.demo.request;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: boot-rabbitmq
 * @description:
 * @author: 001977
 * @create: 2018-07-03 15:16
 */
public class RabbitRequest implements Serializable {

    private String msg;
    private Date time;
    private String routingKey;

    public RabbitRequest() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    @Override
    public String toString() {
        return "RabbitRequest{" +
                "msg='" + msg + '\'' +
                ", time=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time) +
                ", routingKey='" + routingKey + '\'' +
                '}';
    }
}
