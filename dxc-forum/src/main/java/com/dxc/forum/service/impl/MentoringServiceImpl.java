package com.dxc.forum.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.Mentoring;
import com.dxc.forum.helper.MentoringExcelHelper;
import com.dxc.forum.repository.MentoringRepo;
import com.dxc.forum.service.MentoringService;
import com.dxc.forum.utils.ErrorMessageConstants;

@Service
public class MentoringServiceImpl implements MentoringService {

	@Autowired
	private MentoringRepo mentoringRepo;
	
	//Add Data Service Implementation
	@Override
	public Mentoring addMentoring(Mentoring mentoring) {
		if(mentoring.getName().isEmpty() || mentoring.getName().length()==0)	
		{
			throw new BusinessException("701", ErrorMessageConstants.PROPER_MENTORING);
		}else if(mentoring.getBatch().isEmpty() || mentoring.getBatch().length() == 0) {
			throw new BusinessException("719", ErrorMessageConstants.PROPER_MENTORING_BATCH);
		}else if(mentoring.getEmail().isEmpty() || mentoring.getEmail().length() == 0) {
			throw new BusinessException("720", ErrorMessageConstants.PROPER_EMAIL);
		}else if(mentoring.getProject().isEmpty() || mentoring.getProject().length() == 0) {
			throw new BusinessException("721", ErrorMessageConstants.PROPER_MENTORING_PROJECT);
		}else if(mentoring.getProjectStatus().isEmpty() || mentoring.getProjectStatus().length() == 0) {
			throw new BusinessException("722", ErrorMessageConstants.PROPER_MENTORING_PROJECT_STATUS);
		}else if(mentoring.getProjectTitle().isEmpty() || mentoring.getProjectTitle().length() == 0) {
			throw new BusinessException("723", ErrorMessageConstants.PROPER_MENTORING_PROJECT_TITLE);
		}else if(mentoring.getTechStack().isEmpty() || mentoring.getTechStack().length() == 0) {
			throw new BusinessException("724", ErrorMessageConstants.PROPER_MENTORING_TECH_STACK);
		}
		try
		{
			return this.mentoringRepo.save(mentoring);
		}
	catch(IllegalArgumentException e) 
	{
		throw new BusinessException("702", ErrorMessageConstants.PROPER_MENTORING + e.getMessage());
	}
	catch(Exception e)
	{
		throw new BusinessException("703", ErrorMessageConstants.MENTORING_DETAILS_SERVICE_LAYER + e.getMessage());
	}
	}

	//Get Data Service
	@Override
	public List<Mentoring> getAllMentoring() {
		try
		{
			List<Mentoring> mentoringList=mentoringRepo.findAll();
			if(mentoringList.isEmpty())
				throw new BusinessException("704", ErrorMessageConstants.EMPTY_LIST);
			return this.mentoringRepo.findAll();
		}
		catch(Exception e)
		{
			throw new BusinessException("705", ErrorMessageConstants.MENTORING_DETAILS_SERVICE_LAYER + e.getMessage());
		}
		
		
	}

	//Get Specific Data using Id Service
	@Override
	public Mentoring getMentoring(Long id) {
		try
		{
		return this.mentoringRepo.findById(id).get();
		}
		catch(IllegalArgumentException e) 
		{
			throw new BusinessException("706",ErrorMessageConstants.MENTORING_ID_NULL + e.getMessage());
		}
		catch(NoSuchElementException e) 
		{
			throw new BusinessException("707", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("708", ErrorMessageConstants.MENTORING_DETAILS_SERVICE_LAYER + e.getMessage());
		}
	}

	//Update Specific Data using Id Service
	@Override
	public Mentoring updateMentoring(Mentoring mentoring, Long id) {
		if(mentoring.getName().isEmpty() || mentoring.getName().length()==0)	
		{
			throw new BusinessException("725", ErrorMessageConstants.PROPER_MENTORING);
		}else if(mentoring.getBatch().isEmpty() || mentoring.getBatch().length() == 0) {
			throw new BusinessException("726", ErrorMessageConstants.PROPER_MENTORING_BATCH);
		}else if(mentoring.getEmail().isEmpty() || mentoring.getEmail().length() == 0) {
			throw new BusinessException("727", ErrorMessageConstants.PROPER_EMAIL);
		}else if(mentoring.getProject().isEmpty() || mentoring.getProject().length() == 0) {
			throw new BusinessException("728", ErrorMessageConstants.PROPER_MENTORING_PROJECT);
		}else if(mentoring.getProjectStatus().isEmpty() || mentoring.getProjectStatus().length() == 0) {
			throw new BusinessException("729", ErrorMessageConstants.PROPER_MENTORING_PROJECT_STATUS);
		}else if(mentoring.getProjectTitle().isEmpty() || mentoring.getProjectTitle().length() == 0) {
			throw new BusinessException("730", ErrorMessageConstants.PROPER_MENTORING_PROJECT_TITLE);
		}else if(mentoring.getTechStack().isEmpty() || mentoring.getTechStack().length() == 0) {
			throw new BusinessException("731", ErrorMessageConstants.PROPER_MENTORING_TECH_STACK);
		}
		
		try
		{
		Mentoring mentor = this.mentoringRepo.findById(id).get();
		mentor.setBatch(mentoring.getBatch());
		mentor.setEmpId(mentoring.getEmpId());
		mentor.setEmail(mentoring.getEmail());
		mentor.setName(mentoring.getName());
		mentor.setHeScore(mentoring.getHeScore());
		mentor.setUpdateDate(mentoring.getUpdateDate());
		mentor.setHeRank(mentoring.getHeRank());
		mentor.setProject(mentoring.getProject());
		mentor.setProjectTitle(mentoring.getProjectTitle());
		mentor.setProjectStatus(mentoring.getProjectStatus());
		mentor.setTechStack(mentoring.getTechStack());
		return this.mentoringRepo.save(mentor);
		}
		catch(IllegalArgumentException e) 
		{
			throw new BusinessException("709", ErrorMessageConstants.MENTORING_ID_NULL + e.getMessage());
		}
		catch(NoSuchElementException e) 
		{
			throw new BusinessException("710", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("711", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	//Delete Specific Data using ID Service
	@Override
	public void deleteMentoring(Long id) {
		try
		{
		this.mentoringRepo.deleteById(id);
		}
		catch(IllegalArgumentException e) 
		{
			throw new BusinessException("712", ErrorMessageConstants.MENTORING_ID_NULL + e.getMessage());
		}
		catch(NoSuchElementException e) 
		{
			throw new BusinessException("713", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("714", ErrorMessageConstants.MENTORING_DETAILS_SERVICE_LAYER + e.getMessage());
		}
	}

	@Override
	public void uploadExcel(MultipartFile file) {
		try {
			List<Mentoring> mentor = MentoringExcelHelper.convertExcelToList(file.getInputStream());
			this.mentoringRepo.saveAll(mentor);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Long totalEmployee() {
		Long totalEmp = this.mentoringRepo.count();
		return totalEmp;
	}

}
