package com.dxc.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.Answer;
import com.dxc.forum.entity.Question;
import com.dxc.forum.repository.AnswerRepo;
import com.dxc.forum.service.AnswerService;
import com.dxc.forum.utils.ErrorMessageConstants;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepo answerRepo;
	
	//Add Answer Service Implementation
	@Override
	public Answer addAnswer(Answer answer) {
		try {
			if(answer.getAnswer().isEmpty() || answer.getAnswer().length()==0) {
				throw new BusinessException("901", ErrorMessageConstants.PROPER_ANSWER);
			}
		
		return this.answerRepo.save(answer);
	}catch(IllegalArgumentException e) {
		throw new BusinessException("902",ErrorMessageConstants.NULL_ANSWER + e.getMessage());
		
	}catch(Exception e) {
		throw new BusinessException("903", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
	}
		
	}

	//Get All Answer Service Implementation
	@Override
	public List<Answer> getAllAnswer() {
		try {
			List<Answer> ansList=answerRepo.findAll();
			if(ansList.isEmpty())
				throw new BusinessException("904", ErrorMessageConstants.EMPTY_LIST);
			return ansList;	
		}catch(Exception e ) {
			throw new BusinessException("905", ErrorMessageConstants.ERROR_MESSAGE_SERVICE + e.getMessage());
		}
		
	}

	//Get Specific Answer using ID Service Implementation
	@Override
	public Answer getAnswer(Long id) {
		try {
			return this.answerRepo.findById(id).get();
		}catch(IllegalArgumentException e) {
			throw new BusinessException("906", ErrorMessageConstants.NULL_ANSWER + e.getMessage());
			
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("907", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("908", ErrorMessageConstants.ANSWER_ID + e.getMessage());
		}
		
	}

	//Update Specific Answer using ID Service Implementation
	@Override
	public Answer updateAnswer(Answer answer, Long id) {
		if(answer.getAnswer().isEmpty() || answer.getAnswer().length()==0) {
			throw new BusinessException("940", ErrorMessageConstants.PROPER_ANSWER);
		}
		try {
		Answer ans = this.answerRepo.findById(id).get();
		ans.setAnswer(answer.getAnswer());
		ans.setQuestion(answer.getQuestion());
		return this.answerRepo.save(ans);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("909", ErrorMessageConstants.NULL_ANSWER + e.getMessage());
			
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("910", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("911",ErrorMessageConstants.ANSWER_ID + e.getMessage());
		}
	}
	

	//Delete Specific Answer using ID Service
	@Override
	public void deleteAnswer(Long id) {
		try {
			answerRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("912", ErrorMessageConstants.NULL_ANSWER + e.getMessage());
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("913", ErrorMessageConstants.ID_NOT_IN_DB + e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("914",ErrorMessageConstants.ANSWER_ID + e.getMessage());
		}
	}

	@Override
	public List<Answer> findByQuesId(Question ques_id) {
		List <Answer> ansList = this.answerRepo.findByQuestion(ques_id);
		return ansList;
	}

	@Override
	public Long totalAnswer(Question ques_id) {
		List <Answer> ansList = this.answerRepo.findByQuestion(ques_id);
		Long totalAns = (long) ansList.size();
		return totalAns;
	}
}
