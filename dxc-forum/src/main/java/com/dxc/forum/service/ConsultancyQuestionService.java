package com.dxc.forum.service;

import java.util.List;

import com.dxc.forum.entity.ConsultancyQuestion;

public interface ConsultancyQuestionService {

	//Add Question Service
	public ConsultancyQuestion addQuestion(ConsultancyQuestion c_question);
	//Get All Questions Service
	public List<ConsultancyQuestion> getAllQuestion();
	//Get Specific Question using ID Service
	public ConsultancyQuestion getQuestion(Long c_id);
	//Update Specific Question using ID Service
	public ConsultancyQuestion updateQuestion(ConsultancyQuestion c_question, Long c_id);
	//Delete Specific Question using ID Service
	public void deleteQuestion(Long c_id);
	public Long totalQuestion();
}
