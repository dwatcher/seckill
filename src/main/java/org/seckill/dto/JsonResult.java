package org.seckill.dto;

import com.alibaba.fastjson.JSON;

public class JsonResult<T> {

    private int status;
    private T data;
    private String error;

    public JsonResult(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public JsonResult(int status, String error) {
        this.status = status;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

}
