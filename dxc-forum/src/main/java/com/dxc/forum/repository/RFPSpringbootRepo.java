package com.dxc.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.forum.entity.RFP;
import com.dxc.forum.entity.RFPSpringboot;

public interface RFPSpringbootRepo extends JpaRepository<RFPSpringboot, Long> {
	
	public List<RFPSpringboot>  findByRfp(RFP rfp);

}
