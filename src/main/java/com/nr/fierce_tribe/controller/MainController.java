package com.nr.fierce_tribe.controller;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/test")
    public JSONObject test(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data","HelloWorld");
        jsonObject.put("resultCode", "200");
        jsonObject.put("success", true);
        jsonObject.put("message","操作成功");
        return jsonObject;
    }

    @RequestMapping("/test")
    public void test223434324(){

    }

    @RequestMapping("/test")
    public void test22(){

    }
    @GetMapping("/test2")
    public JSONObject test2(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data","HelloWorld2");
        jsonObject.put("resultCode", "200");
        jsonObject.put("success", true);
        jsonObject.put("message","操作成功");
        return jsonObject;
    }
    @RequestMapping("/open")
    public String open(){
        return "success!";
    }

}
