package com.dxc.forum.service;

import java.util.List;

import com.dxc.forum.entity.RFP;

public interface RFPService {

//	Adding RFP Data
	public RFP addRFP(RFP rfp);

//	Getting all RFP data
	public List<RFP> getAllRFP();

//	Getting RFP Data using ID
	public RFP getRFP(Long id);

//	Updating RFP Data using ID
	public RFP updateRFP(Long id, RFP rfp);
	
//	Delete RFP Data using ID
	public void deleteRFP(Long id);
}
