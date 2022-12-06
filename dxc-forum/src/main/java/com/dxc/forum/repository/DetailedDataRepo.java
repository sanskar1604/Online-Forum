package com.dxc.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.forum.entity.DetailedData;

public interface DetailedDataRepo extends JpaRepository<DetailedData,Long>{
	
}
