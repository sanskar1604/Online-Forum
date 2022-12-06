package com.dxc.forum.service;

import java.util.List;

import com.dxc.forum.entity.RFP;
//import com.dxc.forum.entity.RFPSpringboot;
import com.dxc.forum.entity.RFPSpringboot;

public interface RFPSpringbootService {

//	Adding RFPSpringboot Data
	public RFPSpringboot addRFPSpringboot(RFPSpringboot springboot);
	
//	Getting all RFPSpringboot data
	public List<RFPSpringboot> getAllRFPSpringboot();

//	Getting RFPSpringboot Data using ID
	public RFPSpringboot getRFPSpringboot(Long id);

//	Updating RFPSpringboot Data using ID
	public RFPSpringboot updateRFPSpringboot(Long id, RFPSpringboot springboot);
	
//	Delete RFPSpringboot Data using ID
	public void deleteRFPSpringboot(Long id);
	
	public List<RFPSpringboot> findByRfpId(RFP rfp_id);

}
