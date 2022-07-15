package cn.maitian.bss.modules.common.web.exception;


/**
 * 参数异常
 */
public class ParameterException extends IException {

    public ParameterException() {
        super();
    }
    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(Integer code, String message) {
        super(code, message);
    }

}
