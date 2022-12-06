package com.dxc.forum.service;

import java.util.List;

import com.dxc.forum.entity.RFP;
//import com.dxc.forum.entity.RFP;
import com.dxc.forum.entity.RFPPhases;

public interface RFPPhasesService {

//	Adding RFPPhases Data
	public RFPPhases addRFPPhases(RFPPhases phases);
	
//	Getting all RFPPhases data
	public List<RFPPhases> getAllRFPPhases();

//	Getting RFPPhases Data using ID
	public RFPPhases getRFPPhases(Long id);

//	Updating RFPPhases Data using ID
	public RFPPhases updateRFPPhases(Long id, RFPPhases rfpPhases);
	
//	Delete RFPPhases Data using ID
	public void deleteRFPPhases(Long id);
	
	public List<RFPPhases> findByRfpId(RFP rfp_id);

}
