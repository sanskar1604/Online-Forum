package com.dxc.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.forum.entity.Answer;
import com.dxc.forum.entity.Question;

public interface AnswerRepo extends JpaRepository<Answer, Long> {

	public List<Answer> findByQuestion(Question ques_id);
	
	
	
}