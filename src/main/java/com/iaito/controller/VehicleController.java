package com.iaito.controller;

import com.iaito.dto.VehicleDTO;
import com.iaito.model.Vehicle;
import com.iaito.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicleList")
    public String listVehicle(){
        return "vehicle_list";
    }
    @GetMapping("/vehicleRegister")
    public String registerVehicle(){
        return "vehicle_registration";
    }
    @GetMapping("/vehicleEdit")
    public String editVehicle(){
        return "vehicle_edit";
    }
    @GetMapping("/vehicleView")
    public String viewVehicle(){
        return "vehicle_view";
    }

    @PostMapping(value = "/addVehicle", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public VehicleDTO addVehicle(@RequestBody Vehicle vehicle){
        log.info("Recieved VehicleInformation: {} ", vehicle);

        return vehicleService.addVehicle(vehicle);
    }

}
