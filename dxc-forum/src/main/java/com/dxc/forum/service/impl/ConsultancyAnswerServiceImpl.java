package com.dxc.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.forum.custom_exception.BusinessException;
import com.dxc.forum.entity.Answer;
import com.dxc.forum.entity.ConsultancyAnswer;
import com.dxc.forum.entity.ConsultancyQuestion;
import com.dxc.forum.repository.ConsultancyAnswerRepo;
import com.dxc.forum.service.ConsultancyAnswerService;
import com.dxc.forum.utils.ErrorMessageConstants;

@Service
public class ConsultancyAnswerServiceImpl implements ConsultancyAnswerService {

	@Autowired
	private ConsultancyAnswerRepo c_answerRepo;

	// Add Answer Service Implementation
	@Override
	public ConsultancyAnswer addAnswer(ConsultancyAnswer c_answer) {
		try {
			if (c_answer.getAnswer().isEmpty() || c_answer.getAnswer().length() == 0) {
				throw new BusinessException("1001", ErrorMessageConstants.CONSULTANCY_PROPER_ANSWER);
			}

			return this.c_answerRepo.save(c_answer);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1002", ErrorMessageConstants.CONSULTANCY_NULL_ANSWER + e.getMessage());

		} catch (Exception e) {
			throw new BusinessException("1003",
					ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	// Get All Answer Service Implementation
	@Override
	public List<ConsultancyAnswer> getAllAnswer() {
		try {
			List<ConsultancyAnswer> ansList = c_answerRepo.findAll();
			if (ansList.isEmpty())
				throw new BusinessException("1004", ErrorMessageConstants.CONSULTANCY_EMPTY_LIST);
			return ansList;
		} catch (Exception e) {
			throw new BusinessException("1005",
					ErrorMessageConstants.CONSULTANCY_ERROR_MESSAGE_SERVICE + e.getMessage());
		}

	}

	// Get Specific Answer using ID Service Implementation
	@Override
	public ConsultancyAnswer getAnswer(Long c_id) {
		try {
			return this.c_answerRepo.findById(c_id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1006", ErrorMessageConstants.CONSULTANCY_NULL_ANSWER + e.getMessage());

		} catch (java.util.NoSuchElementException e) {
			throw new BusinessException("1007", ErrorMessageConstants.CONSULTANCY_ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("1008", ErrorMessageConstants.CONSULTANCY_ANSWER_ID + e.getMessage());
		}

	}

	// Update Specific Answer using ID Service Implementation
	@Override
	public ConsultancyAnswer updateAnswer(ConsultancyAnswer c_answer, Long c_id) {
		try {
			ConsultancyAnswer c_ans = this.c_answerRepo.findById(c_id).get();
			c_ans.setAnswer(c_answer.getAnswer());
			c_ans.setQuestion(c_answer.getQuestion());
			return this.c_answerRepo.save(c_ans);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1009", ErrorMessageConstants.CONSULTANCY_NULL_ANSWER + e.getMessage());

		} catch (java.util.NoSuchElementException e) {
			throw new BusinessException("1010", ErrorMessageConstants.CONSULTANCY_ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("1011", ErrorMessageConstants.CONSULTANCY_ANSWER_ID + e.getMessage());
		}
	}

	// Delete Specific Answer using ID Service
	@Override
	public void deleteAnswer(Long c_id) {
		try {
			c_answerRepo.deleteById(c_id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("1012", ErrorMessageConstants.CONSULTANCY_NULL_ANSWER + e.getMessage());
		} catch (java.util.NoSuchElementException e) {
			throw new BusinessException("1013", ErrorMessageConstants.CONSULTANCY_ID_NOT_IN_DB + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("1014", ErrorMessageConstants.CONSULTANCY_ANSWER_ID + e.getMessage());
		}
	}

	@Override
	public List<ConsultancyAnswer> findByQuesId(ConsultancyQuestion ques_id) {
		List <ConsultancyAnswer> ansList = this.c_answerRepo.findByQuestion(ques_id);
		return ansList;
	}






}
