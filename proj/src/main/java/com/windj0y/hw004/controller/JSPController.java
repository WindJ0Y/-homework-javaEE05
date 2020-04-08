package com.windj0y.hw004.controller;

import com.windj0y.hw004.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JSPController {

    private final MainService mainService;

    public JSPController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping("/")
    public String Default(){
        return "index";
    }

    @RequestMapping("/index")
    public String Index(){
        return "index";
    }

    @RequestMapping("/student")
    public ModelAndView Student(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mainService",mainService);
        modelAndView.setViewName("student");
        return modelAndView;
    }

    @RequestMapping("/teacher")
    public ModelAndView Teacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mainService",mainService);
        modelAndView.setViewName("teacher");
        return modelAndView;
    }

}
