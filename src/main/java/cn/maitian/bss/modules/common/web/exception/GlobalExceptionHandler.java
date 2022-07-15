package cn.maitian.bss.modules.common.web.exception;


import cn.maitian.bss.modules.common.web.Result;
import cn.maitian.bss.modules.common.web.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.AccessDeniedException;

/**
 * 全局异常处理器
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler (Exception.class)
    public Result handleException(Exception ex, HttpServletResponse response) {
        // 支持跨域
        cross(response);

        // 对不同错误进行不同处理
        if (ex instanceof IException) {
            return Result.failure(((IException) ex).getCode(), ex.getMessage());
        } else if (ex instanceof AccessDeniedException) {
            return Result.failure(ResultCode.ACCESS_DENIED);
        }

        log.error(ex.getMessage(), ex);
        return Result.failure(500, ex.toString());
    }

    private void cross(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, Authorization");
    }
}