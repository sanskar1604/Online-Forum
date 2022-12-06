package com.dxc.forum.service;

import java.util.List;

import com.dxc.forum.entity.ConsultancyAnswer;
import com.dxc.forum.entity.ConsultancyQuestion;

public interface ConsultancyAnswerService {

	//Add Answer Service
	public ConsultancyAnswer addAnswer(ConsultancyAnswer c_answer);
	//Get All Answer Service
	public List<ConsultancyAnswer> getAllAnswer();
	//Get Specific Answer using ID Service
	public ConsultancyAnswer getAnswer(Long c_id);
	//Update Specific Answer using ID Service
	public ConsultancyAnswer updateAnswer(ConsultancyAnswer c_answer, Long c_id);
	//Delete Specific Answer using ID Service
	public void deleteAnswer(Long c_id);
	
	public List<ConsultancyAnswer> findByQuesId(ConsultancyQuestion ques_id);
}
