package com.nr.fierce_tribe.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class MainController {

    @RequestMapping("/open")
    public String open(){
        return "success!";
    }

}
