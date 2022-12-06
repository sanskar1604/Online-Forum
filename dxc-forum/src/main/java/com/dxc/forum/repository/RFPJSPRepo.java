package com.dxc.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.forum.entity.RFP;
import com.dxc.forum.entity.RFPJSP;

public interface RFPJSPRepo extends JpaRepository<RFPJSP, Long> {
	
	public List<RFPJSP>  findByRfp(RFP rfp);

}
