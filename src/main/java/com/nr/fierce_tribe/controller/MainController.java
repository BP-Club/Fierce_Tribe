package com.nr.fierce_tribe.controller;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class MainController {

    @RequestMapping("/test")
    public JSONObject test(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data","HelloWorld");
        jsonObject.put("resultCode", "200");
        jsonObject.put("success", true);
        jsonObject.put("message","操作成功");
        return jsonObject;
    }

}
