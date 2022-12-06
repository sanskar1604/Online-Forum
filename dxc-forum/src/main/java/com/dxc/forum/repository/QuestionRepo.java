package com.dxc.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.forum.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Long>{

}
