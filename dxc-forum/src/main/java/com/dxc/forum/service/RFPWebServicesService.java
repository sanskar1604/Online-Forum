package com.dxc.forum.service;

import java.util.List;

import com.dxc.forum.entity.RFP;
//import com.dxc.forum.entity.RFPWebServices;
import com.dxc.forum.entity.RFPWebServices;

public interface RFPWebServicesService {

//	Adding RFPWebServices Data
	public RFPWebServices addRFPWebServices(RFPWebServices webservice);
	
//	Getting all RFPWebServices data
	public List<RFPWebServices> getAllRFPWebServices();

//	Getting RFPWebServices Data using ID
	public RFPWebServices getRFPWebServices(Long id);

//	Updating RFPWebServices Data using ID
	public RFPWebServices updateRFPWebServices(Long id, RFPWebServices webservice);
	
//	Delete RFPWebServices Data using ID
	public void deleteRFPWebServices(Long id);
	
	public List<RFPWebServices> findByRfpId(RFP rfp_id);

}
