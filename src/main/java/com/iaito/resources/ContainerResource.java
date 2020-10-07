package com.iaito.resources;

import com.iaito.dto.ContainerDTO;
import com.iaito.model.Container;
import com.iaito.service.ContainerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
public class ContainerResource {
    private final ContainerService containerService;
    private final ModelMapper modelMapper;

    @Autowired
    public ContainerResource(ContainerService containerService, ModelMapper modelMapper) {
        this.containerService = containerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ContainerDTO>> getAllContainers(){
        return ResponseEntity.ok(containerService.getAllContainer());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContainerDTO> getContainerById(@PathVariable Long id){
        return containerService.getContainerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContainerDTO addContainer(@RequestBody Container container){
        return containerService.addContainer(container);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContainerDTO> updateContainer(@PathVariable Long id, @RequestBody Container container){
        return containerService.getContainerById(id)
                .map(containerObj -> {
                        container.setContainerId(id);
                        return ResponseEntity.ok(containerService.addContainer(container));
                    }
                )
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContainerDTO> deleteUser(@PathVariable Long id){
        return containerService.getContainerById(id)
                .map(container -> {
                    containerService.deleteContainer(id);
                    return ResponseEntity.ok(modelMapper.map(container, ContainerDTO.class));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
