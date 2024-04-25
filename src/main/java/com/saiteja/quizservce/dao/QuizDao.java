package com.saiteja.quizservce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saiteja.quizservce.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
