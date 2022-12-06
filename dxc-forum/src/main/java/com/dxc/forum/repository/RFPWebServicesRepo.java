package com.dxc.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.forum.entity.RFP;
import com.dxc.forum.entity.RFPWebServices;

public interface RFPWebServicesRepo extends JpaRepository<RFPWebServices, Long> {
	
	public List<RFPWebServices>  findByRfp(RFP rfp);

}
