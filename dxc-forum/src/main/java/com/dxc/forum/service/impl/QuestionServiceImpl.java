package com.dxc.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.Question;
import com.dxc.forum.repository.QuestionRepo;
import com.dxc.forum.service.QuestionService;
import com.dxc.forum.utils.ErrorMessageConstants;
@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;

	//Add Question Service Implementation
	@Override
	public Question addQuestion(Question question) {
		if(question.getTitle().isEmpty() || question.getTitle().length()==0) {
			throw new BusinessException("920", ErrorMessageConstants.PROPER_QUESTION);
		}else if(question.getBody().isEmpty() || question.getBody().length() == 0) {
			throw new BusinessException("937", ErrorMessageConstants.PROPER_QUESTION_BODY);
		}
		try {
		return this.questionRepo.save(question);
	}catch(IllegalArgumentException e) {
		throw new BusinessException("921",ErrorMessageConstants.QUESTION_ID_NULL + e.getMessage());
		
	}catch(Exception e) {
		throw new BusinessException("922", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
	}
		
		
	}

	//Get All Questions Service Implementation
	@Override
	public List<Question> getAllQuestion() {
		try {
			List<Question> quesList=this.questionRepo.findAll();
			if(quesList.isEmpty())
				throw new BusinessException("923", ErrorMessageConstants.EMPTY_LIST);
			return quesList;	
		}catch(Exception e ) {
			throw new BusinessException("924", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	//Get Specific Question using ID Service Implementation
	@Override
	public Question getQuestion(Long id) {
		try {
			return this.questionRepo.findById(id).get();
		}catch(IllegalArgumentException e) {
			throw new BusinessException("925", ErrorMessageConstants.QUESTION_ID_NULL + e.getMessage());
			
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("926", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("927", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
		
	}

	//Update Specific Question using ID Service Implementation
	@Override
	public Question updateQuestion(Question question, Long id) {
		if(question.getTitle().isEmpty() || question.getTitle().length()==0) {
			throw new BusinessException("938", ErrorMessageConstants.PROPER_QUESTION);
		}else if(question.getBody().isEmpty() || question.getBody().length() == 0) {
			throw new BusinessException("939", ErrorMessageConstants.PROPER_QUESTION_BODY);
		}
		try {
		Question ques = this.questionRepo.findById(id).get();
		ques.setTitle(question.getTitle());
		ques.setBody(question.getBody());
		return this.questionRepo.save(ques);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("928",ErrorMessageConstants.QUESTION_ID_NULL + e.getMessage());
			
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("929",ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("930", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	
	//Delete Specific Question using ID Service Implementation
	@Override
	public void deleteQuestion(Long id) {
		try {
		questionRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("931", ErrorMessageConstants.QUESTION_ID_NULL + e.getMessage());
			
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("932", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("933", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
		
	}

	@Override
	public Long totalQuestion() {
		Long question = this.questionRepo.count();
		return question;
	}

}
