package com.dxc.forum.service;

import java.util.List;

import com.dxc.forum.entity.RFP;
//import com.dxc.forum.entity.RFPJSP;
import com.dxc.forum.entity.RFPJSP;

public interface RFPJSPService {

//	Adding RFPJSP Data
	public RFPJSP addRFPJSP(RFPJSP jsp);
	
//	Getting all RFPJSP data
	public List<RFPJSP> getAllRFPJSP();

//	Getting RFPJSP Data using ID
	public RFPJSP getRFPJSP(Long id);

//	Updating RFPJSP Data using ID
	public RFPJSP updateRFPJSP(Long id, RFPJSP jsp);
	
//	Delete RFPJSP Data using ID
	public void deleteRFPJSP(Long id);
	
	public List<RFPJSP> findByRfpId(RFP rfp_id);

}
