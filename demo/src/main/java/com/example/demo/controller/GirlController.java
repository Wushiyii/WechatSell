package com.example.demo.controller;

import com.example.demo.domain.Girl;
import com.example.demo.Repository.GirlRepository;
import com.example.demo.domain.Result;
import com.example.demo.service.GirlService;
import com.example.demo.utils.ResultUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){

      return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return null;
            //return ResultUtil.fail(1,bindingResult.getFieldError().getDefaultMessage());
        }


        return ResultUtil.success(girlRepository.save(girl));
    }
    /**
     * 查询一个女生
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable Integer id){
        logger.info("girlFindOne!!!!!!!!!!!!!!!!!");
        return girlRepository.findOne(id);
    }
    /**
     * 修改
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable Integer id,String cupSize,Integer age){
        Girl girl = girlRepository.getOne(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable Integer id){
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable Integer id) throws RuntimeException{
        girlService.getAge(id);
    }

}
