package com.dxc.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dxc.forum.entity.RFP;
import com.dxc.forum.entity.RFPPhases;

public interface RFPPhasesRepo extends JpaRepository<RFPPhases, Long> {
	
	public List<RFPPhases> findByRfp(RFP rfp);
	

}
