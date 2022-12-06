package com.dxc.forum.service;

import java.util.List;

import com.dxc.forum.entity.Answer;
import com.dxc.forum.entity.Question;

public interface AnswerService {

	//Add Answer Service
	public Answer addAnswer(Answer answer);
	//Get All Answer Service
	public List<Answer> getAllAnswer();
	//Get Specific Answer using ID Service
	public Answer getAnswer(Long id);
	//Update Specific Answer using ID Service
	public Answer updateAnswer(Answer answer, Long id);
	//Delete Specific Answer using ID Service
	public void deleteAnswer(Long id);
	
	public List<Answer> findByQuesId(Question ques_id);
	
	public Long totalAnswer(Question ques_id);
}
