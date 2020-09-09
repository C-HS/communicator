package com.iaito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iaito.dto.AssetDTO;
import com.iaito.model.Asset;
import com.iaito.service.AssetService;

@RestController
public class AssetController {
	@Autowired AssetService assetService;
	
	@GetMapping(value = "/asset/{assetId}", produces = "application/json")
	public ResponseEntity<AssetDTO> findAssetById(@PathVariable("assetId") Long assetId){
		return ResponseEntity.ok(assetService.getAssetById(assetId));
	}
	@GetMapping(value = "/asset/{tagId}", produces = "application/json")
	public ResponseEntity<AssetDTO> findAssetByTag(@PathVariable("tagId") String tagId){
		return ResponseEntity.ok(assetService.getAssetByTagId(tagId));
	}
	@GetMapping(value = "/asset", produces = "application/json")
	public ResponseEntity<List<AssetDTO>> findAllAsset(){
		return ResponseEntity.ok(assetService.getAllAsset());
	}
	@PostMapping(value = "/asset", consumes = "application/json")
	public ResponseEntity<String> addAsset(@RequestBody Asset asset){
		assetService.addAsset(asset);
		return ResponseEntity.ok("Saved Successfully");
	}
	@DeleteMapping(value = "/asset", consumes = "application/json")
	public ResponseEntity<String> deleteAsset(@RequestBody Asset asset){
		assetService.deleteAsset(asset);
		return ResponseEntity.ok("Deleted Successfully");
	}
	@PutMapping(value = "/asset", consumes = "application/json")
	public ResponseEntity<AssetDTO> updateAsset(@RequestBody Asset asset){
		return null;
	}

}
