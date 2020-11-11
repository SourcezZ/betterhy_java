package com.betterhy.exception;

import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.Objects;

/**
 * Global exception handler.
 *
 * @author heyuan
 * @date 2020/07/09
 */
@RestControllerAdvice
public class DefaultExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        String message = e.getMessage();

        if (e instanceof IllegalArgumentException) {
            message = "传入了错误的参数";
        }

        if (e instanceof MethodArgumentNotValidException) {
            message = Objects.requireNonNull(((MethodArgumentNotValidException) e).getBindingResult().getFieldError()).getDefaultMessage();
        }

        if (e instanceof UnauthorizedException) {
            message = "权限认证失败";
        }

        if (e instanceof MaxUploadSizeExceededException){
            message = "文件大小超出10MB限制, 请压缩或降低文件质量!";
        }

        logger.error(message);
        return ResultFactory.buildFailResult(message);
    }
}
