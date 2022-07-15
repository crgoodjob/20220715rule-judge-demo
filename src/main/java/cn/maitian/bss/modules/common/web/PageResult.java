package cn.maitian.bss.modules.common.web;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 分页查询通用返回结果
 */
@Data
@Accessors(chain = true)
public class PageResult<T> implements Serializable {

    // 状态码
    private Integer code = 200;

    // 提示信息
    private String msg;

    //总数量
    private long count;

    // 当前页数据
    private T data;

    // 时间截
    private long timestamp ;

    public PageResult() {
        this.timestamp = System.currentTimeMillis();
    }

    public PageResult(T data) {
        // this.code = ResultCode.SUCCESS.getCode();
        this.data = data;
        this.count = 1;
        this.timestamp = System.currentTimeMillis();
    }

    public PageResult(T data, long total) {
        // this.code = ResultCode.SUCCESS.getCode();
        this.count = total;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public PageResult(T data, long total,Integer code) {
        this.code = code;
        this.count = total;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }
}
