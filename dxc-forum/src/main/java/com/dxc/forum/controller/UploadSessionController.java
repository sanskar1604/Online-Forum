package com.dxc.forum.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.custom_exception.ControllerException;
import com.dxc.forum.entity.Mentoring;
import com.dxc.forum.entity.UploadSession;
import com.dxc.forum.helper.ExcelFileExporter;
import com.dxc.forum.helper.SessionExcelHelper;
import com.dxc.forum.service.UploadSessionService;
import com.dxc.forum.utils.ErrorMessageConstants;
import com.dxc.forum.utils.MessageConstants;

@CrossOrigin("*")
@RestController
public class UploadSessionController {

	@Autowired
	private UploadSessionService service;
	
//	for adding session details
	@PostMapping("/session")
	public ResponseEntity<?> addUploadSession(@RequestBody UploadSession uploadSession)
	{
//		return service.saveUploadSession(uploadSession);
		try
		{
		UploadSession uploadSessionSaved=service.saveUploadSession(uploadSession);
		return new ResponseEntity<UploadSession>(uploadSessionSaved,HttpStatus.CREATED);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("815", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
	}
	
	
//	get all sessions
	@GetMapping("/session")
	public ResponseEntity<List<UploadSession>> findAllUploadSessions()
	{
		List<UploadSession> listOfUploadSessions=service.getUploadSessions();
		return new ResponseEntity<List<UploadSession>>(listOfUploadSessions,HttpStatus.OK);
	}
	
	
//	get session by id
	@GetMapping("/session/{id}")
	public ResponseEntity<?> findUploadSessionById(@PathVariable Long id)
	{
		try
		{
		UploadSession uploadSessionRetrieved=service.getUploadSessionById(id);
		return new ResponseEntity<UploadSession>(uploadSessionRetrieved,HttpStatus.OK);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("816", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
	}

//	for updating the existing session by id
	@PutMapping("/session/{id}")
	public ResponseEntity<?> updateUploadSession(@RequestBody UploadSession uploadSession,@PathVariable Long id )
	{
		try
		{
		UploadSession uploadSessionUpdated=service.updateUploadSession(uploadSession, id);
		return new ResponseEntity<UploadSession>(uploadSessionUpdated,HttpStatus.OK);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("817", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
	}
	
//	for deleting the session by id
	@DeleteMapping("/session/{id}")
	public ResponseEntity<?> deleteUploadSession(@PathVariable Long id)
	{
		try
		{
				service.deleteUploadSession(id);
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("818", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
	}
	
	
	@PostMapping("/session-excel")
	public ResponseEntity<?> uploadSessionExcel(@RequestParam("file") MultipartFile file){
		if(SessionExcelHelper.checkExcelFormat(file)) {
			this.service.uploadSessionExcel(file);
			return ResponseEntity.ok(Map.of("message", MessageConstants.EXCEL_UPLOAD_SUCCESS));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageConstants.PLEASE_UPLOAD_EXCEL);
	}
	
	@GetMapping("/session/total")
	public Long totalSession() {
		return this.service.totalSession();
	}
	
	@GetMapping("/download/training.xlsx")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=Training.xlsx");
        List <UploadSession> trainings = this.service.getUploadSessions();
        
        ByteArrayInputStream stream = ExcelFileExporter.trainingListToExcelFile(trainings);
        IOUtils.copy(stream, response.getOutputStream());
    }
}
