package com.example.demo.controller;

import com.example.demo.domain.Boy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private Boy boy;



    //public String hello(@PathVariable("id") Integer id){       @PathVariable获取REST风格参数

    //@RequestMapping(value = "/hello",method = RequestMethod.GET)
    @GetMapping(value = "/hello") //相当于 method = RequestMethod.GET
    public String hello(@RequestParam(value = "id",defaultValue = "0",required = false) Integer id){

        return "id :"+id;
    }

}
