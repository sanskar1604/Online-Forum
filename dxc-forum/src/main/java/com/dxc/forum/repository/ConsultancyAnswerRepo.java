package com.dxc.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.forum.entity.ConsultancyAnswer;
import com.dxc.forum.entity.ConsultancyQuestion;

public interface ConsultancyAnswerRepo extends JpaRepository<ConsultancyAnswer, Long> {

	public List<ConsultancyAnswer> findByQuestion(ConsultancyQuestion ques_id);
	
}