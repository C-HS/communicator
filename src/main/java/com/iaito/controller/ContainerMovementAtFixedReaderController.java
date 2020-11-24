package com.iaito.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iaito.dto.ContainerDTO;
import com.iaito.dto.ContainerMovementAtFixedReaderDTO;
import com.iaito.report.DailyMovementDTO;
import com.iaito.report.TransitionDTO;
import com.iaito.service.ContainerMovementAtFixedReaderService;

@Controller
public class ContainerMovementAtFixedReaderController {
	
	@Autowired ContainerMovementAtFixedReaderService movementAtFixedReaderService;

    @GetMapping("/movemetAtFixedReader")
    public ModelAndView movementAtFixedReaderList(){
       // return "movement_at_fixedreader_list";
    	
      	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("movement_at_fixedreader_list");
        
        List<ContainerMovementAtFixedReaderDTO> containerMovementAtFixedReaderList = new ArrayList<>();
        
        containerMovementAtFixedReaderList = movementAtFixedReaderService.getAllContainerMovementAtFixedReader();
        
        System.out.println("movementList "+containerMovementAtFixedReaderList.size());
        
        modelAndView.addObject("movementList", containerMovementAtFixedReaderList);
    	
        return modelAndView;
    }
    
    @GetMapping("/containerHistory/{containerNo}")
    public ResponseEntity<List<ContainerMovementAtFixedReaderDTO>> containerHistory(@PathVariable String containerNo){
    	
    	System.out.println("containerNo "+containerNo);
        
        List<ContainerMovementAtFixedReaderDTO> containerMovementAtFixedReaderList = new ArrayList<>();
        
       containerMovementAtFixedReaderList = movementAtFixedReaderService.getContainerMovementByContainerNumber(containerNo);
        
       // System.out.println("movementList "+containerMovementAtFixedReaderList);

        return ResponseEntity.status(200).body(containerMovementAtFixedReaderList);
    }
    
    @GetMapping("/locateContainer/{containerNo}")
    public ResponseEntity<ContainerMovementAtFixedReaderDTO> locateContainer(@PathVariable String containerNo){
    	
    	System.out.println("containerNo "+containerNo);
        
        ContainerMovementAtFixedReaderDTO containerMovementAtFixedReader = null;
        
        containerMovementAtFixedReader = movementAtFixedReaderService.getLastLocationByContainerNumber(containerNo);
        
        System.out.println("########################################### "+containerMovementAtFixedReader);

        return ResponseEntity.status(200).body(containerMovementAtFixedReader);
    }
    
    @GetMapping("/dailyContainerMovement/{containerNo}")
    public ResponseEntity<Map<String,DailyMovementDTO>> dailyContainerMovement(@PathVariable String containerNo){
    	
       System.out.println("containerNo "+containerNo);
    	
       List<ContainerMovementAtFixedReaderDTO> containerMovementAtFixedReaderList = new ArrayList<>();
        
       containerMovementAtFixedReaderList = movementAtFixedReaderService.getContainerMovementByContainerNumber(containerNo);
       
      // List<Map<String,DailyMovementDTO>> listDailyMovement = new ArrayList<>();
       
       Map<String,DailyMovementDTO> dailyMovement = new LinkedHashMap<>();
       
       DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

       Date prevDate=null;
       
       for(ContainerMovementAtFixedReaderDTO dto : containerMovementAtFixedReaderList)
       {
    	  if(dto.getMovementType().equals("Rover"))
    	  {
    		  
        	  Date dt = dto.getDateTime();

        	  String date =  formatter.format(dt);
        	  
        	  if(prevDate!=null)
        	  {
        		  if(date.equals(formatter.format(prevDate)))
        		  {
        			  DailyMovementDTO dmdto = dailyMovement.get(date);
        			  
        			  int noOfTrans = dmdto.getTransitionList().size();
        			  
        			  TransitionDTO transdto = dmdto.getTransitionList().get(noOfTrans-1);
        			  
        			  long diff = dto.getDateTime().getTime() - transdto.getEndTime().getTime();
        			  
        			  long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
        			 // long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        			  
        			  if(seconds<300)
        			  {
                		  transdto.setEndTime(dto.getDateTime());
                		  double sec = transdto.getTimeTaken()+ seconds;
                		  transdto.setTimeTaken(sec);
                		  
                		  double distTravelled = calculateDistance(dto,transdto);
                		  
                		  transdto.setDistanceTravelled(transdto.getDistanceTravelled()+distTravelled);
                		  transdto.setLat(Double.parseDouble(dto.getLatitude()));
                		  transdto.setLon(Double.parseDouble(dto.getLongitude()));
                		  
                		  if(dto.getAreaId()==0)
                		  {
                			  dmdto.setDestination(dto.getLatitude()+","+dto.getLongitude());
                			  transdto.setDestination(dto.getLatitude()+","+dto.getLongitude());
                		  }
                		  else
                		  {
                			  dmdto.setDestination(dto.getAreaName());
                			  transdto.setDestination(dto.getAreaName());
                		  }
                		  
                		  dmdto.setEndTime(dto.getDateTime());
                		  double s = dmdto.getTimeTaken()+ seconds;
                		  dmdto.setTimeTaken(s);
                		  dmdto.setDistanceTravelled(dmdto.getDistanceTravelled()+distTravelled);
                		  
        			  }
        			  else
        			  {
        				  double distTravelled = calculateDistance(dto,transdto);
        				  TransitionDTO transdtoNew = new TransitionDTO();
        				  
        				  transdtoNew.setId(dmdto.getTransitionList().size()+1);
        				  transdtoNew.setStartTime(dto.getDateTime());
        				  transdtoNew.setEndTime(dto.getDateTime());
        				  transdtoNew.setDistanceTravelled(0);
        				  transdtoNew.setTimeTaken(0);
        				  transdtoNew.setLat(Double.parseDouble(dto.getLatitude()));
        				  transdtoNew.setLon(Double.parseDouble(dto.getLongitude()));
                		  
                		  if(dto.getAreaId()==0)
                		  {
                			  transdtoNew.setSource(dto.getLatitude()+","+dto.getLongitude());
                			  transdtoNew.setDestination(dto.getLatitude()+","+dto.getLongitude());
                		  }
                		  else
                		  {
                			  transdtoNew.setSource(dto.getAreaName());
                			  transdtoNew.setDestination(dto.getAreaName());
                		  }
                		  
                		  dmdto.setDistanceTravelled(dmdto.getDistanceTravelled()+distTravelled);
                		  dmdto.getTransitionList().add(transdtoNew);
        			  }
        			  
        		  }
        		  else
        		  {
        			  createMovementForNewDate(date,dto,dailyMovement);
        		  }
        		  
        		  prevDate = dt;
        	  }
        	  else
        	  {
        		  
        		  prevDate = dt;
        		  createMovementForNewDate(date,dto,dailyMovement);
        		  
//        		  DailyMovementDTO dmdto = new DailyMovementDTO();
//        		  TransitionDTO transdto = new TransitionDTO();
//        		  
//        		  dmdto.setDateStr(date);
//        		  dmdto.setDistanceTravelled(0);
//        		  dmdto.setTimeTaken(0);
//        		  dmdto.setStartTime(dto.getDateTime());
//        		  dmdto.setEndTime(dto.getDateTime());
//        		  
//        		  if(dto.getAreaId()==0)
//        		  {
//        			  dmdto.setSource(dto.getLatitude()+","+dto.getLongitude());
//        			  transdto.setSource(dto.getLatitude()+","+dto.getLongitude());
//        		  }
//        		  else
//        		  {
//        			  dmdto.setSource(dto.getAreaName());
//        			  transdto.setSource(dto.getAreaName());
//        		  }
//        		  transdto.setId(1);
//        		  transdto.setStartTime(dto.getDateTime());
//        		  transdto.setEndTime(dto.getDateTime());
//        		  transdto.setDistanceTravelled(0);
//        		  transdto.setTimeTaken(0);
//        		  transdto.setLat(Double.parseDouble(dto.getLatitude()));
//        		  transdto.setLon(Double.parseDouble(dto.getLongitude()));
//        		  
//        		  dmdto.getTransitionList().add(transdto);
//        		  dailyMovement.put(date, dmdto);
        	  }
    	  }
       }

       // System.out.println("movementList "+containerMovementAtFixedReaderList);

        return ResponseEntity.status(200).body(dailyMovement);
    }
    
    // convert Decimal Degrees To Radians
    private double deg2rad(double deg)
    {
    	return(deg * Math.PI/180.0);
    }
    
    // convert Radians To Decimal Degrees To 
    private double rad2deg(double rad)
    {
    	return(rad * 180.0 / Math.PI);
    }
    
    private double calculateDistance(ContainerMovementAtFixedReaderDTO dto,TransitionDTO transdto)
    {
		  double theta = Double.parseDouble(dto.getLongitude()) - transdto.getLon();
		  double dist = Math.sin(deg2rad(Double.parseDouble(dto.getLatitude()))) * Math.sin(deg2rad(transdto.getLat())) + Math.cos(deg2rad(Double.parseDouble(dto.getLatitude()))) * Math.cos(deg2rad(transdto.getLat())) * Math.cos(deg2rad(theta));
		  dist = Math.acos(dist);
		  dist = rad2deg(dist);
		  dist = dist * 60 * 1.1515;
		  
		  dist = dist * 1.609344; // kilometers
		  
		  return dist;
    }
    
    public void createMovementForNewDate(String date,ContainerMovementAtFixedReaderDTO dto,Map<String,DailyMovementDTO> dailyMovement)
    {
		  
		  DailyMovementDTO dmdto = new DailyMovementDTO();
		  TransitionDTO transdto = new TransitionDTO();
		  
		  dmdto.setDateStr(date);
		  dmdto.setDistanceTravelled(0);
		  dmdto.setTimeTaken(0);
		  dmdto.setStartTime(dto.getDateTime());
		  dmdto.setEndTime(dto.getDateTime());
		  
		  if(dto.getAreaId()==0)
		  {
			  dmdto.setSource(dto.getLatitude()+","+dto.getLongitude());
			  transdto.setSource(dto.getLatitude()+","+dto.getLongitude());
			  transdto.setDestination(dto.getLatitude()+","+dto.getLongitude());
			  dmdto.setDestination(dto.getLatitude()+","+dto.getLongitude());
		  }
		  else
		  {
			  dmdto.setSource(dto.getAreaName());
			  transdto.setSource(dto.getAreaName());
			  transdto.setDestination(dto.getAreaName());
			  dmdto.setDestination(dto.getAreaName());
		  }
		  transdto.setId(1);
		  transdto.setStartTime(dto.getDateTime());
		  transdto.setEndTime(dto.getDateTime());
		  transdto.setDistanceTravelled(0);
		  transdto.setTimeTaken(0);
		  transdto.setLat(Double.parseDouble(dto.getLatitude()));
		  transdto.setLon(Double.parseDouble(dto.getLongitude()));
		  
		  dmdto.getTransitionList().add(transdto);
		  dailyMovement.put(date, dmdto);
    }
	
}
