package com.dxc.forum.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.UploadSession;
import com.dxc.forum.helper.SessionExcelHelper;
import com.dxc.forum.repository.UploadSessionRepo;
import com.dxc.forum.service.UploadSessionService;
import com.dxc.forum.utils.ErrorMessageConstants;


@Service
public class UploadSessionServiceImpl implements UploadSessionService{

	@Autowired
	private UploadSessionRepo repository;

//	adding session details
	@Override
	public UploadSession saveUploadSession(UploadSession uploadSession)
	{
		if(uploadSession.getTopicName().isEmpty() || uploadSession.getTopicName().length()==0)	
		{
			throw new BusinessException("801", ErrorMessageConstants.PROPER_TOPIC_NAME);
		}else if(uploadSession.getBatch().isEmpty() || uploadSession.getBatch().length() == 0) {
			throw new BusinessException("820", ErrorMessageConstants.PROPER_BATCH_NAME);
		}
//		else if(uploadSession.getSessionDate().isEmpty() || uploadSession.getSessionDate().length() == 0) {
//			throw new BusinessException("822", ErrorMessageConstants.PROPER_SESSION_DATE);
//		}
		else if(uploadSession.getSessionLink().isEmpty() || uploadSession.getSessionLink().length() == 0) {
			throw new BusinessException("823", ErrorMessageConstants.PROPER_SESSION_LINK);
		}
//		else if(uploadSession.getSessionTime().isEmpty() || uploadSession.getSessionTime().length() == 0) {
//			throw new BusinessException("824", ErrorMessageConstants.PROPER_SESSION_TIME);
//		}
		else if(uploadSession.getSessionVideo().isEmpty() || uploadSession.getSessionVideo().length() == 0) {
			throw new BusinessException("825", ErrorMessageConstants.PROPER_SESSION_VIDEO);
		}else if(uploadSession.getTrainerName().isEmpty() || uploadSession.getTrainerName().length() == 0) {
			throw new BusinessException("826", ErrorMessageConstants.PROPER_SESSION_TRAINER_NAME);
		}
		try
		{
			return repository.save(uploadSession);
		}
		catch(IllegalArgumentException e) 
		{
			throw new BusinessException("802", ErrorMessageConstants.SESSION_ID_NULL + e.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("803", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
		
	}	
	
	
//	getting all session details
	@Override
	public List<UploadSession> getUploadSessions()
	{
		try
		{
			List<UploadSession> sessionList=repository.findAll();
			if(sessionList.isEmpty())
				throw new BusinessException("804",ErrorMessageConstants.EMPTY_LIST);
			return sessionList;
//			return repository.findAll();
		}
		catch(Exception e)
		{
			throw new BusinessException("805", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
		
		
	}
	
	
//	getting session by id
	@Override
	public UploadSession getUploadSessionById(Long id)
	{
		try
		{
			return repository.findById(id).get();
//			return repository.findById(id).orElse(null);
		}
		catch(IllegalArgumentException e) 
		{
			throw new BusinessException("806", ErrorMessageConstants.SESSION_ID_NULL + e.getMessage());
		}
		catch(NoSuchElementException e) 
		{
			throw new BusinessException("807", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("808", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	

	
//	updating session by id
	@Override
	public UploadSession updateUploadSession(UploadSession uploadSession,Long id)
	{
		if(uploadSession.getTopicName().isEmpty() || uploadSession.getTopicName().length()==0)	
		{
			throw new BusinessException("827", ErrorMessageConstants.PROPER_TOPIC_NAME);
		}else if(uploadSession.getBatch().isEmpty() || uploadSession.getBatch().length() == 0) {
			throw new BusinessException("828", ErrorMessageConstants.PROPER_BATCH_NAME);
		}
//		else if(uploadSession.getSessionDate().isEmpty() || uploadSession.getSessionDate().length() == 0) {
//			throw new BusinessException("830", ErrorMessageConstants.PROPER_SESSION_DATE);
//		}
		else if(uploadSession.getSessionLink().isEmpty() || uploadSession.getSessionLink().length() == 0) {
			throw new BusinessException("831", ErrorMessageConstants.PROPER_SESSION_LINK);
		}
//		else if(uploadSession.getSessionTime().isEmpty() || uploadSession.getSessionTime().length() == 0) {
//			throw new BusinessException("834", ErrorMessageConstants.PROPER_SESSION_TIME);
//		}
		else if(uploadSession.getSessionVideo().isEmpty() || uploadSession.getSessionVideo().length() == 0) {
			throw new BusinessException("835", ErrorMessageConstants.PROPER_SESSION_VIDEO);
		}else if(uploadSession.getTrainerName().isEmpty() || uploadSession.getTrainerName().length() == 0) {
			throw new BusinessException("836", ErrorMessageConstants.PROPER_SESSION_TRAINER_NAME);
		}
		try
		{
		UploadSession existingUploadSession=repository.findById(id).orElse(null);
		existingUploadSession.setTopicName(uploadSession.getTopicName());
		existingUploadSession.setSessionDate(uploadSession.getSessionDate());
		existingUploadSession.setSessionVideo(uploadSession.getSessionVideo());
		existingUploadSession.setSessionLink(uploadSession.getSessionLink());
		existingUploadSession.setTrainerName(uploadSession.getTrainerName());
		return repository.save(existingUploadSession);
		}
		catch(IllegalArgumentException e) 
		{
			throw new BusinessException("812", ErrorMessageConstants.SESSION_ID_NULL + e.getMessage());
		}
		catch(NoSuchElementException e) 
		{
			throw new BusinessException("813", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("814", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	
	
//	deleting an existing system by id
	@Override
	public void deleteUploadSession(Long id)
	{
		try 
		{
			repository.deleteById(id);
//			return "UploadedSession removed!!"+id;
		}
		catch(IllegalArgumentException e) 
		{
			throw new BusinessException("809", ErrorMessageConstants.SESSION_ID_NULL + e.getMessage());
		}
		catch(NoSuchElementException e) 
		{
			throw new BusinessException("810", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("811", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}
	
	@Override
	public void uploadSessionExcel(MultipartFile file) {
		try {
			List<UploadSession> uploadSession = SessionExcelHelper.convertExcelToList(file.getInputStream());
			this.repository.saveAll(uploadSession);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public Long totalSession() {
		Long totalSession = this.repository.count();
		return totalSession;
	}

	
	
	
}
