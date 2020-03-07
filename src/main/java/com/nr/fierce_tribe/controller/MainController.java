package com.nr.fierce_tribe.controller;


import com.nr.fierce_tribe.entity.api.RestApiResult;
import com.nr.fierce_tribe.entity.api.RestApiResultImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/api")
@Api(description = "哈，哈么？")
public class MainController {

    @GetMapping("/open")
    @ApiOperation(value="进入项目",notes = "促")
    public RestApiResult open(){
        String str="{\"name\":\"zhangsan\",\"password\":\"zhangsan123\",\"email\":\"304757948@qq.com\"}";
        return new RestApiResultImpl(str);
    }

}
