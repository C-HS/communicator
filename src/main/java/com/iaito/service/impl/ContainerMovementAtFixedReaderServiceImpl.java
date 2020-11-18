package com.iaito.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.ContainerAreaDTO;
import com.iaito.dto.ContainerDTO;
import com.iaito.dto.ContainerMovementAtFixedReaderDTO;
import com.iaito.model.ContainerMovementAtFixedReader;
import com.iaito.model.VehicleDevice;
import com.iaito.repository.ContainerMovementAtFixedReaderRepository;
import com.iaito.service.ContainerAreaService;
import com.iaito.service.ContainerMovementAtFixedReaderService;
import com.iaito.service.ContainerService;

import pointinploygon.PointInPloygon;

@Service
public class ContainerMovementAtFixedReaderServiceImpl implements ContainerMovementAtFixedReaderService{

	@Autowired ContainerMovementAtFixedReaderRepository repository;
	@Autowired ModelMapper modelMapper;
	
	@Autowired ContainerService containerService;
	@Autowired ContainerAreaService containerAreaService;
	
	List<ContainerAreaDTO> areaList;
	
	@Override
	public String addContainerMovementAtFixedReader(ContainerMovementAtFixedReader containerMovementAtFixedReader) {

		//repository.save(containerMovementAtFixedReader);
		
		try
		{
			modelMapper.map(repository.save(containerMovementAtFixedReader), ContainerMovementAtFixedReaderDTO.class);
			
			return "success";
		}
		catch(org.springframework.dao.DataIntegrityViolationException e)
		{
			return "already_exist";			
		}
		catch(Exception e)
		{
			return "register_error";	
		}
		
	}
	
	@Override
	public String addContainerMovementAtRover(VehicleDevice vehicleDevice) {
		try
		{
    		String tagdata = vehicleDevice.getTagId();
    		tagdata = HextoAscii(tagdata.substring(6));
    		ContainerDTO containerDTO = containerService.getContainerByContainerNo(tagdata);
			ContainerMovementAtFixedReader movement = new ContainerMovementAtFixedReader();
			movement.setEpc(vehicleDevice.getTagId());
			movement.setLatitude(vehicleDevice.getLatitude());
			movement.setLongitude(vehicleDevice.getLongitude());
			movement.setAltitude(vehicleDevice.getAltitude());
			if(containerDTO!=null && containerDTO.getContainerId()!=0)
			{
			movement.setContainerId(containerDTO.getContainerId());
			movement.setContainerNo(containerDTO.getContainerNumber());
			}
			else
			{
				movement.setContainerId(0);
				movement.setContainerNo("NA");
			}
			movement.setMovementType("Rover");
			movement.setDateTime(new Date());
			
			areaList = containerAreaService.getAllContainerArea();
			PointInPloygon pip = new PointInPloygon();

			for(ContainerAreaDTO area : areaList) 
			{
				
//				if(area.getAreaName().equals("Testing"))
//				{
//					 boolean b1 = pip.checkPointInOut(80.259106,26.511191, area.getAreaJson());
//					 
//					 boolean b2 = pip.checkPointInOut(80.259098,26.511165, area.getAreaJson());
//					 
//					 System.out.println("################ "+b1);
//					 System.out.println("$$$$$$$$$$$$$$$$ "+b2);
//				}
				
				 boolean b = pip.checkPointInOut(Double.parseDouble(vehicleDevice.getLongitude()),Double.parseDouble(vehicleDevice.getLatitude()), area.getAreaJson());
				 if(b)
				 {
					 movement.setAreaId(area.getAreaId());
					 movement.setAreaName(area.getAreaName());
					 break;
				 }
			}
			repository.save(movement);
			return "success";
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e.getMessage());
			return "register_error";	
		}
	}
	

	@Override
	public ContainerMovementAtFixedReaderDTO updateContainerMovementAtFixedReader(
			ContainerMovementAtFixedReader containerMovementAtFixedReader) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerMovementAtFixedReaderDTO getContainerMovementAtFixedReaderByID(long movementId) {

		return modelMapper.map(repository.findById(movementId), ContainerMovementAtFixedReaderDTO.class);
	}

	@Override
	public List<ContainerMovementAtFixedReaderDTO> getContainerMovementAtFixedReaderByReaderID(long readerId) {

		return repository
				.findByReaderId(readerId)
				.stream()
				.map(e -> modelMapper.map(e, ContainerMovementAtFixedReaderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerMovementAtFixedReaderDTO> getContainerMovementAtFixedReaderByEPC(String epc) {

		return repository
				.findByEpc(epc)
				.stream()
				.map(e -> modelMapper.map(e, ContainerMovementAtFixedReaderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerMovementAtFixedReaderDTO> getContainerMovementAtFixedReaderByContainerID(long containerId) {

		return repository
				.findByContainerId(containerId)
				.stream()
				.map(e -> modelMapper.map(e, ContainerMovementAtFixedReaderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ContainerMovementAtFixedReaderDTO> getAllContainerMovementAtFixedReader() {

		return repository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, ContainerMovementAtFixedReaderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteContainerMovementAtFixedReader(ContainerMovementAtFixedReader containerMovementAtFixedReader) {

		repository.delete(containerMovementAtFixedReader);
		
	}
	
    public String HextoAscii(String hex){
        byte b[]=new byte[150];
        String ascii="";
        int counter=0,i=0;
        try{

            for(i=0;i<(hex.length());i=i+2,counter++){
                {

                    b[counter]=(byte)Integer.parseInt(hex.substring(i,i+2),16);
                }

            }// end of the for loop
        }catch(Exception ex){ascii="Error";}
        ascii=new String(b).substring(0,counter);
        return ascii;

    }

}
