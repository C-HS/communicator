package com.iaito.controller;


import com.iaito.model.User;
import com.iaito.model.UserPrinciple;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class HomeController {

    @GetMapping("/mapview")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mapview");
        return modelAndView;
    }
    @GetMapping({"/","/dashboard"})
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @GetMapping("/register")
    public ModelAndView userRegister() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userRegister");
        return modelAndView;
    }

    @PostMapping("/postLogin")
    public String postLogin(Model model, HttpSession httpSession){
       log.info("postLogin()");
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        ValidatePrinciple(authentication.getPrincipal());
        User loggedInUser = ((UserPrinciple) authentication.getPrincipal()).getUserDetails();
        model.addAttribute("currentUser", loggedInUser.getUserName());
        httpSession.setAttribute("userId", loggedInUser.getId());
        return "redirect:/dashboard";
    }
    @GetMapping("/loginFailed")
    public String loginError(Model model){
        log.info("Login attempt failed!!");
        model.addAttribute("error", "true");
        return "/login";
    }
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus){
        SecurityContextHolder.getContext().setAuthentication(null);
        sessionStatus.setComplete();
        return "redirect:/login";
    }
    private void ValidatePrinciple(Object principal) {
        if(!(principal instanceof UserPrinciple)){
            throw new IllegalArgumentException("Principle can't be null");
        }
    }

}
