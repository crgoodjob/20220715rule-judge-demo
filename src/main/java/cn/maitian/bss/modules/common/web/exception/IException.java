package cn.maitian.bss.modules.common.web.exception;

import lombok.Data;

/**
 * 自定义异常基类
 */
@Data
public abstract class IException extends RuntimeException {

    private Integer code;

    public IException() {
    }

    public IException(String message) {
        super(message);
    }

    public IException(Integer code, String message) {
        super(message);
        this.code = code;
    }


}
