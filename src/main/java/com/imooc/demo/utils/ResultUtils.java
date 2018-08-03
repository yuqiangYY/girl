package com.imooc.demo.utils;

import com.imooc.demo.eneity.Result;

public class ResultUtils {

    /**
     * 返回成功(带参数)
     * @return
     */
    public static Result sucess(Object object){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    /**
     * 返回成功(不带参数)
     * @return
     */
    public static Result sucess(){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    /**
     * 返回失败
     * @return
     */
    public static Result Error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
