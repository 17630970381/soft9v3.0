package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.AppControlManage;
import com.example.demo.mapper.AppControlManageMapper;
import com.example.demo.service.AppControlManageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class test {

    @Resource
    private AppControlManageService appControlManageService;

    @Resource
    private AppControlManageMapper appControlManageMapper;

    @PostMapping("/postTest")
    public Object test(@RequestBody JSONObject object, final HttpServletResponse response, final HttpServletRequest request) {
        AppControlManage appControlManage = object.toJavaObject(AppControlManage.class);
        boolean save = appControlManageService.save(appControlManage);
        if (save) {
            System.out.println("保存成功");
        } else {
            System.out.println("保存失败");
        }
        return appControlManage;
    }


    @GetMapping("/getAll/{id}")
    public AppControlManage getAll(@PathVariable Integer id){
        return appControlManageService.getById(id);
    }

}
