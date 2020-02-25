package com.nr.fierce_tribe.DW.ODS.controller;


import com.nr.fierce_tribe.DW.ODS.entity.RequsetTableInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController()
@RequestMapping("/tableInfo")
public class TableAddInfo {
    @PostMapping("/add")
    @ResponseBody
    public String addInfo(@RequestBody RequsetTableInfo qequsetTableInfo){
        System.out.println(qequsetTableInfo);
        return "success";

    }
}