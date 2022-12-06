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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.custom_exception.ControllerException;
import com.dxc.forum.entity.ConsultancyAnswer;
import com.dxc.forum.entity.ConsultancyQuestion;
import com.dxc.forum.service.ConsultancyAnswerService;
import com.dxc.forum.utils.ErrorMessageConstants;

@RestController
@CrossOrigin("*")
//@RequestMapping("/consultancy_answer")
public class ConsultancyAnswerController {

//	private static final HttpStatus ResponseEntity = null;
	@Autowired
	private ConsultancyAnswerService c_answerService;
	
	//Add Answer
	@PostMapping("/consultancy_answer")
	public ResponseEntity<?> addAnswer(@RequestBody ConsultancyAnswer c_answer) {
		try {
			ConsultancyAnswer c_ansSaved = c_answerService.addAnswer(c_answer);
			return new ResponseEntity<ConsultancyAnswer>(c_ansSaved,HttpStatus.CREATED);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("1015", ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		
	}
	
	//Get All Answer
	@GetMapping("/consultancy_answer")
	public ResponseEntity<List<ConsultancyAnswer>> getAllAnswer(){
		List<ConsultancyAnswer> listOfAns =c_answerService.getAllAnswer();
		return new ResponseEntity<List<ConsultancyAnswer>>(listOfAns , HttpStatus.OK);
	}
	
	//Get Specific Answer using ID 
	@GetMapping("/consultancy_answer/{c_id}")
	public ResponseEntity<?> getAnswer(@PathVariable("c_id") Long c_id) {
		try {
			ConsultancyAnswer c_ansRetrieved = c_answerService.getAnswer(c_id);
			return new ResponseEntity<ConsultancyAnswer>(c_ansRetrieved,HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("1016", ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
		
	}
	
	//Update Specific Answer using ID
	@PutMapping("/consultancy_answer/{c_id}")
	public ResponseEntity<?> updateAnswer(@RequestBody ConsultancyAnswer c_answer, @PathVariable("c_id") Long c_id) {
		try {
			ConsultancyAnswer c_ansUpdated = c_answerService.updateAnswer(c_answer,c_id);
		return new ResponseEntity<ConsultancyAnswer>(c_ansUpdated,HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(),e.getErrorMsg());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("1017", ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_CONTROLLER);
			return new ResponseEntity<ControllerException>(ce,HttpStatus.OK);
		}
	}
	
	//Delete Specific Answer using ID
	@DeleteMapping("/consultancy_answer/{c_id}")
	public ResponseEntity<?> deleteAnswer(@PathVariable("c_id") Long c_id) {
		
		c_answerService.deleteAnswer(c_id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/c_ansbyquesid/{id}")
	public List<ConsultancyAnswer> findByQuesId(@PathVariable("id") ConsultancyQuestion id){
		return this.c_answerService.findByQuesId(id);
	}
	
}
