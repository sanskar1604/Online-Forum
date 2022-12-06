package com.dxc.forum.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.dxc.forum.entity.UploadSession;

public interface UploadSessionService {

//	adding session details
	public UploadSession saveUploadSession(UploadSession uploadSession);
	
//	adding list of session details
//	public List<UploadSession> saveUploadSessions(List<UploadSession> uploadSessions);
	
//	get all sessions' details
	public List<UploadSession> getUploadSessions();
	
//	get particular session details by id
	public UploadSession getUploadSessionById(Long id);
	
//	get particular session details by topicname
//	public UploadSession getUploadSessionByTopicName(String topicName);
	
//	update existing session by id
	public UploadSession updateUploadSession(UploadSession uploadSession,Long id);
		
//	delete session details by id
//	public String deleteUploadSession(int id);
	public void deleteUploadSession(Long id);
	
	public void uploadSessionExcel(MultipartFile file);
	
	public Long totalSession();
}
