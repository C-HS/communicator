package com.iaito.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping("/error")
    public String handleError(HttpServletRequest httpServletRequest){
        Object status = httpServletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null){
            int statusCode = Integer.parseInt(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()){
                return "error-404";
            }else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                return "error-500";
            }else if(statusCode == HttpStatus.FORBIDDEN.value()){
                return "accessDenied";
            }
        }
        return "error";
    }
}
