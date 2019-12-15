package com.moliniao.common;

import java.io.Serializable;

/**
 * @author: created by limingzhou
 * @date: 2019/11/28
 * @description: PACKAGE_NAME
 */
public class Result<T> implements Serializable {

    private String code = "000";

    private String message = "";

    private Boolean success = false;

    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(String code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> success(T data) {
        Result result = new Result();
        result.setCode("000");
        result.setMessage("success");
        result.setSuccess(true);
        result.setData(data);
       return result;
    }

    public static <T> Result<T> fail(String code, String message) {
        Result<T> result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setSuccess(false);
        result.setData(null);
        return result;
    }

    public static <T> Result<T> fail(String code, String message, T data) {
        Result<T> result = new Result();
        result.setCode(code);
        result.setData(data);
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
