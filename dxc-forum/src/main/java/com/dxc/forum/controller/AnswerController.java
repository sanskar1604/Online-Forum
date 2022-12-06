package com.dxc.forum.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.custom_exception.ControllerException;
import com.dxc.forum.entity.Answer;
import com.dxc.forum.entity.Question;
import com.dxc.forum.service.AnswerService;
import com.dxc.forum.utils.ErrorMessageConstants;

@RestController
@CrossOrigin("*")
public class AnswerController {

	@Autowired
	private AnswerService answerService;
	
	//Add Answer
	@PostMapping("/answer")
	public ResponseEntity<?> addAnswer(@RequestBody Answer answer) {
		try {
			Answer ansSaved = answerService.addAnswer(answer);
			return new ResponseEntity<Answer>(ansSaved,HttpStatus.CREATED);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("915", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		
	}
	
	//Get All Answer
	@GetMapping("/answer")
	public ResponseEntity<List<Answer>> getAllAnswer(){
		List<Answer> listOfAns =answerService.getAllAnswer();
		return new ResponseEntity<List<Answer>>(listOfAns , HttpStatus.OK);
	}
	
	//Get Specific Answer using ID 
	@GetMapping("/answer/{id}")
	public ResponseEntity<?> getAnswer(@PathVariable("id") Long id) {
		try {
			Answer ansRetrieved = answerService.getAnswer(id);
			return new ResponseEntity<Answer>(ansRetrieved,HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("916", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		
	}
	
	//Update Specific Answer using ID
	@PutMapping("/answer/{id}")
	public ResponseEntity<?> updateAnswer(@RequestBody Answer answer, @PathVariable("id") Long id) {
		try {
			Answer ansUpdated = answerService.updateAnswer(answer,id);
		return new ResponseEntity<Answer>(ansUpdated,HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("917", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
	}
	
	//Delete Specific Answer using ID
	@DeleteMapping("/answer/{id}")
	public ResponseEntity<?> deleteAnswer(@PathVariable("id") Long id) {
		
		answerService.deleteAnswer(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/ansbyquesid/{id}")
	public List<Answer> findByQuesId(@PathVariable("id") Question id){
		return this.answerService.findByQuesId(id);
	}
	
	@GetMapping("/totalAns/{id}")
	public Long totalAnswer(@PathVariable("id") Question id) {
		return this.answerService.totalAnswer(id);
	}
	
}
