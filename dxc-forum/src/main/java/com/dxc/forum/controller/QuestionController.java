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
import org.springframework.web.bind.annotation.RestController;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.custom_exception.ControllerException;
import com.dxc.forum.entity.Question;
import com.dxc.forum.service.QuestionService;
import com.dxc.forum.utils.ErrorMessageConstants;

@RestController
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questioService;
	
	//Add Question
	@PostMapping("/question")
	public ResponseEntity<?> addQuestion(@RequestBody Question question) {
		try {
			Question quesSaved = questioService.addQuestion(question);
			return new ResponseEntity<Question>(quesSaved,HttpStatus.CREATED);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("934", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		
	}
	
	//Get All Question
	@GetMapping("/question")
	public ResponseEntity<?> getAllQuestion(){
		return ResponseEntity.ok(this.questioService.getAllQuestion());
	}
	
	//Get Specific Question using ID
	@GetMapping("/question/{id}")
	public ResponseEntity<?> getQuestion(@PathVariable("id") Long id) {
		try {
			Question quesRetrieved = questioService.getQuestion(id);
			return new ResponseEntity<Question>(quesRetrieved,HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("935", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		
	}
	
	//Update Specific Question using ID
	@PutMapping("/question/{id}")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question, @PathVariable("id") Long id) {
		try {
			Question quesUpdatated = questioService.updateQuestion(question, id);
		return  new ResponseEntity<Question>(quesUpdatated,HttpStatus.OK);
	}catch(BusinessException e) {
		ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
		return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
	}catch(Exception e) {
		ControllerException ce = new ControllerException("936", ErrorMessageConstants.ERROR_MESSAGE_CONTROLLER);
		return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
	}
	}
	
	//Delete Specific Question using ID
	@DeleteMapping("/question/{id}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable("id") Long id) {
		
		questioService.deleteQuestion(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/total_question")
	public Long totalQuestion() {
		return this.questioService.totalQuestion();
	}
}
