package com.iaito.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iaito.dto.ReaderLocationDTO;
import com.iaito.model.ReaderLocation;
import com.iaito.service.ReaderLocationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReaderLocationController {
    private final ReaderLocationService readerLocationService;

    public ReaderLocationController(ReaderLocationService readerLocationService) {
        this.readerLocationService = readerLocationService;
    }
    @GetMapping("/readerLocationList")
    public ModelAndView listReaderLocation(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("readerLocationList", readerLocationService.getAllReaderLocation());
        modelAndView.setViewName("reader_location_list");
        
       // System.out.println("@@@@@@@@@@@@@@@@@@@@@    "+readerLocationService.getAllReaderLocation().size());
        
        return modelAndView;
    }
    @GetMapping("/readerLocationRegistration")
    public ModelAndView readerLocationRegistration(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reader_location_registration");
        return modelAndView;
    }
    @PostMapping(value = "/readerLocationRegistration")
    @ResponseBody
    public ReaderLocationDTO registerReaderLocation(@RequestBody ReaderLocation readerLocation){
        log.info("Added the Reader Location Information for {}", readerLocation);
        
        readerLocation.setStatus("REGISTERED");
        
        readerLocation.setDateCreated(new Date());
        
        return readerLocationService.addReaderLocation(readerLocation);
    }

    @GetMapping("/readerLocationEdit/{readerLocationId}")
    public ModelAndView readerLocationEdit(@PathVariable long readerLocationId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reader_location_edit");
        return modelAndView;
    }
    @GetMapping("/readerLocationView/{readerLocationId}")
    public ModelAndView readerLocationView(@PathVariable long readerLocationId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reader_location_view");
        return modelAndView;
    }
}
