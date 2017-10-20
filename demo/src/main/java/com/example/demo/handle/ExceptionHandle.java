package com.example.demo.handle;

import com.example.demo.domain.Result;
import com.example.demo.exception.GirlException;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获异常
 */

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.fail(girlException.getCode(),girlException.getMessage());

        }else {

            logger.error("【系统异常】:",e);
            return ResultUtil.fail(-1, "未知错误");

        }
    }
}
