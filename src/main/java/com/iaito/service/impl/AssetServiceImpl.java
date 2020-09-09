package com.iaito.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.dto.AssetDTO;
import com.iaito.model.Asset;
import com.iaito.repository.AssetRepository;
import com.iaito.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService {
	
	@Autowired AssetRepository assetRepository;
	@Autowired ModelMapper modelMapper;

	@Override
	public void addAsset(Asset asset) {
		assetRepository.save(asset);
	}

	@Override
	public AssetDTO updateAsset(Asset asset) {
		return null;
	}

	@Override
	public AssetDTO getAssetById(long assetId) {
		return modelMapper.map(assetRepository.findById(assetId), AssetDTO.class);
	}

	@Override
	public AssetDTO getAssetByTagId(String tagId) {
		return modelMapper.map(assetRepository.findAssetByTagId(tagId), AssetDTO.class);
	}

	@Override
	public List<AssetDTO> getAllAsset() {
		return assetRepository
				.findAll()
				.stream()
				.map(e -> modelMapper.map(e, AssetDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAsset(Asset asset) {
		assetRepository.delete(asset);
	}

}
