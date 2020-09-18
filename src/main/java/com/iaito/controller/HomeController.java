package com.iaito.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping({"/","/home"})
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
}
