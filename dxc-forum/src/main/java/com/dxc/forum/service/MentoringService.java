package com.dxc.forum.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dxc.forum.entity.Mentoring;

public interface MentoringService {

	
	//Add Data Service
	public Mentoring addMentoring(Mentoring mentoring);
	
	//Get Data Service
	public List<Mentoring> getAllMentoring();
	
	//Get Specific Data using Id Service
	public Mentoring getMentoring(Long id);
	
	//Update Specific Data using Id Service
	public Mentoring updateMentoring(Mentoring mentoring, Long id);
	
	//Delete Specific Data using ID Service
	public void deleteMentoring(Long id);
	
	//Upload Excel Sheet
	public void uploadExcel(MultipartFile file);
	
	public Long totalEmployee();
}
