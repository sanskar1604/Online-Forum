package com.dxc.forum.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.custom_exception.ControllerException;
import com.dxc.forum.entity.ConsultancyQuestion;
import com.dxc.forum.service.ConsultancyQuestionService;
import com.dxc.forum.utils.ErrorMessageConstants;

@RestController
@CrossOrigin("*")
@RequestMapping("/consultancy_question")
public class ConsultancyQuestionController {

	@Autowired
	private ConsultancyQuestionService c_questioService;
	
	//Add Question
	@PostMapping
	public ResponseEntity<?> addQuestion(@RequestBody ConsultancyQuestion c_question) {
		try {
			ConsultancyQuestion c_quesSaved = c_questioService.addQuestion(c_question);
			return new ResponseEntity<ConsultancyQuestion>(c_quesSaved,HttpStatus.CREATED);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("1034", ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		
	}
	
	//Get All Question
	@GetMapping
	public ResponseEntity<?> getAllQuestion(){
		return ResponseEntity.ok(this.c_questioService.getAllQuestion());
	}
	
	//Get Specific Question using ID
	@GetMapping("/{c_id}")
	public ResponseEntity<?> getQuestion(@PathVariable("c_id") Long c_id) {
		try {
			ConsultancyQuestion c_quesRetrieved = c_questioService.getQuestion(c_id);
			return new ResponseEntity<ConsultancyQuestion>(c_quesRetrieved,HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("1035", ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		
	}
	
	//Update Specific Question using ID
	@PutMapping("/{c_id}")
	public ResponseEntity<?> updateQuestion(@RequestBody ConsultancyQuestion c_question, @PathVariable("c_id") Long c_id) {
		try {
			ConsultancyQuestion c_quesUpdatated = c_questioService.updateQuestion(c_question, c_id);
		return  new ResponseEntity<ConsultancyQuestion>(c_quesUpdatated,HttpStatus.OK);
	}catch(BusinessException e) {
		ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
		return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
	}catch(Exception e) {
		ControllerException ce = new ControllerException("1036", ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_CONTROLLER);
		return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
	}
	}
	
	//Delete Specific Question using ID
	@DeleteMapping("/{c_id}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable("c_id") Long c_id) {
		
		c_questioService.deleteQuestion(c_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/c_total_question")
	public Long totalQuestion() {
		return this.c_questioService.totalQuestion();
	}
}
