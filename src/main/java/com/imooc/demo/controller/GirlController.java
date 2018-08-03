package com.imooc.demo.controller;

import com.imooc.demo.eneity.Girl;
import com.imooc.demo.eneity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.imooc.demo.utils.ResultUtils;
import com.imooc.demo.service.GirlService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlService girlService;

    /**
     * 查询女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlService.findAll();
    }

    /**
     * 添加女生信息
     *
     * @return
     */
    @PostMapping(value = "/add")
    public Result<Girl> addGirl(@Valid  Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultUtils.Error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return ResultUtils.sucess(girlService.save(girl));
    }

    /**
     * 根据id查找女生信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/one/{id}")
    public Optional<Girl> findById(@PathVariable("id") Integer id) {
        Optional<Girl> girl = girlService.findById(id);
        return girl;
    }

    /**
     * 修改女生信息
     */
    @PutMapping(value = "/upd/{id}")
    public Girl updateById(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize) {
        Girl girl = girlService.getOne(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlService.save(girl);
    }

    /**
     * 根据id查询删除指定数据
     * @param id
     */
    @DeleteMapping(value = "/del/{id}")
    public void deleteById(@PathVariable("id") Integer id){
         girlService.deleteById(id);
    }

    /**
     * 根据年龄查询girl列表
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/by/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age){
        List<Girl> girlList = girlService.findByAge(age);
        return girlList;
    }

    /**
     * 查询一个女生市哪个年龄段的
     */
    @GetMapping(value = "/girl/how/age")
    public void findGirlAge(@PathVariable("age") Integer id){
        Girl girl = girlService.getOne(id);
    }
}
