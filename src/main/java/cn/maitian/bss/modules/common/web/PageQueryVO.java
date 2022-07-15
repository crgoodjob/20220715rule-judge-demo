package cn.maitian.bss.modules.common.web;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页查询通用请求
 */
@Data
public class PageQueryVO implements Serializable {

    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 排序方式(asc,desc)
     */
    private String sort;

    /**
     * 记录总数
     */
    private long count;

    /**
     * 页码(第几页)
     */
    private Integer pageNo = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;
}
