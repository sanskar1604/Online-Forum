package com.dxc.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.ConsultancyQuestion;
import com.dxc.forum.repository.ConsultancyQuestionRepo;
import com.dxc.forum.service.ConsultancyQuestionService;
import com.dxc.forum.utils.ErrorMessageConstants;

@Service
public class ConsultancyQuestionServiceImpl implements ConsultancyQuestionService {

	@Autowired
	private ConsultancyQuestionRepo c_questionRepo;

	// Add Question Service Implementation
	@Override
	public ConsultancyQuestion addQuestion(ConsultancyQuestion c_question) {
		if (c_question.getTitle().isEmpty() || c_question.getTitle().length() == 0) {
			throw new BusinessException("1020", ErrorMessageConstants.CONSULTANCY_PROPER_QUESTION);
		} else if (c_question.getBody().isEmpty() || c_question.getBody().length() == 0) {

			throw new BusinessException("1090", ErrorMessageConstants.CONSULTANCY_PROPER_QUESTION_BODY);
		}

		try {

			return this.c_questionRepo.save(c_question);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1021", ErrorMessageConstants.CONSULTANCY_QUESTION_ID_NULL + e.getMessage());

		} catch (Exception e) {
			throw new BusinessException("1022",
					ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	// Get All Questions Service Implementation
	@Override
	public List<ConsultancyQuestion> getAllQuestion() {
		try {
			List<ConsultancyQuestion> c_quesList = this.c_questionRepo.findAll();
			if (c_quesList.isEmpty())
				throw new BusinessException("1023", ErrorMessageConstants.CONSULTANCY_EMPTY_LIST);
			return c_quesList;
		} catch (Exception e) {
			throw new BusinessException("1024",
					ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	// Get Specific Question using ID Service Implementation
	@Override
	public ConsultancyQuestion getQuestion(Long c_id) {
		try {
			return this.c_questionRepo.findById(c_id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1025", ErrorMessageConstants.CONSULTANCY_QUESTION_ID_NULL + e.getMessage());

		} catch (java.util.NoSuchElementException e) {
			throw new BusinessException("1026", ErrorMessageConstants.CONSULTANCY_ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("1027",
					ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	// Update Specific Question using ID Service Implementation
	@Override
	public ConsultancyQuestion updateQuestion(ConsultancyQuestion c_question, Long c_id) {

		if (c_question.getTitle().isEmpty() || c_question.getTitle().length() == 0) {
			throw new BusinessException("1091", ErrorMessageConstants.CONSULTANCY_UPDATE_QUESTION_TITLE);
		} else if (c_question.getBody().isEmpty() || c_question.getBody().length() == 0) {

			throw new BusinessException("1092", ErrorMessageConstants.CONSULTANCY_UPDATE_QUESTION_BODY);
		}

		try {
			ConsultancyQuestion c_ques = this.c_questionRepo.findById(c_id).get();
			c_ques.setTitle(c_question.getTitle());
			c_ques.setBody(c_question.getBody());
			c_ques.setCategory(c_question.getCategory());
			
			return this.c_questionRepo.save(c_ques);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1028", ErrorMessageConstants.CONSULTANCY_QUESTION_ID_NULL + e.getMessage());

		} catch (java.util.NoSuchElementException e) {
			throw new BusinessException("1029", ErrorMessageConstants.CONSULTANCY_ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("1030",
					ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_SERVICE + e.getMessage());
		}
	}

	// Delete Specific Question using ID Service Implementation
	@Override
	public void deleteQuestion(Long c_id) {
		try {
			c_questionRepo.deleteById(c_id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1031", ErrorMessageConstants.CONSULTANCY_QUESTION_ID_NULL + e.getMessage());

		} catch (java.util.NoSuchElementException e) {
			throw new BusinessException("1032", ErrorMessageConstants.CONSULTANCY_ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("1033",
					ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	@Override
	public Long totalQuestion() {
		Long c_question = this.c_questionRepo.count();
		return c_question;
	}

}
