package com.iaito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserRegistrationController {

    @GetMapping("/registerUser")
    public String registerUser(){
        return "user_registration";
    }
    @GetMapping("/listUser")
    public String listUser(){
        return "user_list";
    }
    @GetMapping("/editUser")
    public String editUser(){
        return "user_edit";
    }
    @GetMapping("/viewUser")
    public String viewUser(){
        return "user_view";
    }
}
