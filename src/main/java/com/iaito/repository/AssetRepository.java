package com.iaito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.model.Asset;
@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
	public Asset findAssetByTagId(String tagId);
}
