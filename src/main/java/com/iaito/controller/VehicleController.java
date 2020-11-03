package com.iaito.controller;

import com.iaito.dto.VehicleDTO;
import com.iaito.model.Vehicle;
import com.iaito.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicleList")
    public ModelAndView listVehicle(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vehicle_list");
        modelAndView.addObject("vehicleList", vehicleService.getAllVehicle());
        return modelAndView;
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
        log.info("Recieved Vehicle Information: {} ", vehicle);
        
        vehicle.setStatus("REGISTERED");
        vehicle.setRegisterDate(new Date());
        
        if(vehicle.getVehicleDeviceId()!=0)
        {
        	vehicle.setMountingStatus("MOUNTED");
        	vehicle.setMountingDate(new Date());
        }
        else
        {
        	vehicle.setMountingStatus("UNMOUNTED");
        }
        
        return vehicleService.addVehicle(vehicle);
    }
    @PatchMapping(value = "/updateVehicle", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public VehicleDTO updateVehicle(@RequestBody Vehicle vehicle){
        log.info("Recieved Vehicle Information: {} ", vehicle);
        return vehicleService.updateVehicle(vehicle);
    }
    @PostMapping(value = "/listVehicle", produces = "application/json")
    @ResponseBody
    public List<VehicleDTO> vehicleList(){
        List<VehicleDTO> list = vehicleService.getAllVehicle();
        log.info("List of Vehicle Information: {}", list);
        return  list;
    }
    @GetMapping(value = "/showVehicle/{vehicleId}", produces = "application/json")
    @ResponseBody
    public VehicleDTO showVehicle(@PathVariable long vehicleId){
        VehicleDTO vehicle = vehicleService.getVehicleByID(vehicleId);
        log.info("Gathered Vehicle Information: {}", vehicle);
        return vehicle;
    }
    @DeleteMapping(value = "/{vehicleId}")
    @ResponseBody
    public boolean deleteVehicle(@RequestBody Vehicle vehicle){
        vehicleService.deleteVehicle(vehicle);
        log.info("Deleted the Vehicle: {}", vehicle);
        return true;
    }

}
