package com.saiteja.quizservce.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.saiteja.quizservce.feign.QuizInterface;
import com.saiteja.quizservce.model.QuestionWrapper;
import com.saiteja.quizservce.model.Quiz;
import com.saiteja.quizservce.model.Response;

@Service
public class QuizService {
	
	@Autowired
	com.saiteja.quizservce.dao.QuizDao quizDao;
	
//	@Autowired
//	QuestionDao questionDao;
	
	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Integer> questions = quizInterface.getQuestionsFromQuiz(category, numQ).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromIds(questionIds);
		return questions;
		
	}

	public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> responses) {
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		return score;
	}


}
