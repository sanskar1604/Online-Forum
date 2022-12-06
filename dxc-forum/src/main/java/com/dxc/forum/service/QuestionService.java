package com.dxc.forum.service;

import java.util.List;

import com.dxc.forum.entity.Question;

public interface QuestionService {

	//Add Question Service
	public Question addQuestion(Question question);
	//Get All Questions Service
	public List<Question> getAllQuestion();
	//Get Specific Question using ID Service
	public Question getQuestion(Long id);
	//Update Specific Question using ID Service
	public Question updateQuestion(Question question, Long id);
	//Delete Specific Question using ID Service
	public void deleteQuestion(Long id);
	public Long totalQuestion();
}
