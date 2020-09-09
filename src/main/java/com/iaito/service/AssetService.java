package com.iaito.service;

import java.util.List;

import com.iaito.dto.AssetDTO;
import com.iaito.model.Asset;

public interface AssetService {
	public void addAsset(Asset asset);
	public AssetDTO updateAsset(Asset asset);
	public AssetDTO getAssetById(long assetId);
	public AssetDTO getAssetByTagId(String tagId);
	public List<AssetDTO> getAllAsset();
	public void deleteAsset(Asset asset);
}
