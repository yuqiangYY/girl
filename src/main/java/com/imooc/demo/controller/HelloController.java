package com.imooc.demo.controller;

import com.imooc.demo.eneity.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    /**
     * 两种获取参数的方式
     * @param id
     * @return
     */
    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return "id"+id;
    }
    @RequestMapping(value = "/listen",method = RequestMethod.GET)
    public String listen(@RequestParam("id") Integer myId){
        return "id"+ myId;
    }
}
