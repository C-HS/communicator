package com.iaito.controller;

import com.iaito.dto.ReaderLocationDTO;
import com.iaito.model.ReaderLocation;
import com.iaito.service.ReaderLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
