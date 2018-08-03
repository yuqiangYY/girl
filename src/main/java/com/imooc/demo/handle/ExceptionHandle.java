package com.imooc.demo.handle;

import com.imooc.demo.eneity.Result;
import com.imooc.demo.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获异常类
 */
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 捕获到异常之后，处理捕获到的异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        return ResultUtils.Error(100,e.getMessage());
    }
}
