package cn.maitian.bss.modules.common.web;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一API响应结果格式封装
 */
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    private long timestamp;

    public Result() {
        this.timestamp = System.currentTimeMillis();
    }

    public Result setResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        return this;
    }

    public Result setResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        this.setData(data);
        return this;
    }

    public Result setResult(Integer code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.setData(data);
        return this;
    }

    // 只返回状态
    public static Result success() {
        return new Result()
                .setResult(ResultCode.SUCCESS);
    }

    // 成功返回数据
    public static Result success(Object data) {
        return new Result()
                .setResult(ResultCode.SUCCESS, data);
    }

    public static Result success(ResultCode resultCode) {
        return new Result()
                .setResult(resultCode);
    }

    public static Result success(ResultCode resultCode, Object data) {
        return new Result()
                .setResult(resultCode, data);
    }

    public static Result success(String message, Object data) {
        return new Result()
                .setResult(ResultCode.SUCCESS.getCode(), message, data);
    }



    // 失败
    public static Result failure(ResultCode resultCode) {
        return new Result()
                .setResult(resultCode);
    }

    // 失败
    public static Result failure(String message) {
        Result result = new Result();
        result.setCode(400);
        result.setMsg(message);
        return result;
    }

    // 失败
    public static Result failure(ResultCode resultCode, Object data) {
        return new Result()
                .setResult(resultCode, data);
    }

    // 失败
    public static Result failure(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }


}