package com.windj0y.hw004.controller;

import com.windj0y.hw004.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v2")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }


    @RequestMapping(value = "/addStudent", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String AddStudent(@RequestParam("name") String name){
        return (mainService.addStudent(name) ? "添加成功" : "添加失败" );
    }

    @RequestMapping(value = "/addHomework", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String AddHomework(@RequestParam("name") String name){
        return (mainService.addHomework(name) ? "添加成功" : "添加失败" );
    }

    @RequestMapping(value = "/submitHomework", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String SubmitHomework(@RequestParam("sid") int sid,
                                 @RequestParam("hid") int hid,
                                 @RequestParam("content") String content){
        return (mainService.submitHomework(sid,hid,content) ? "提交成功" : "提交失败" );
    }


}
