package com.saiteja.quizservce.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class Quiz {
	
	@Id
	private int id;
	private String title;
	
	
	@ElementCollection
	List<Integer> questionIds;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<Integer> getQuestionIds() {
		return questionIds;
	}


	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}


	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", questionIds=" + questionIds + "]";
	}
	
	

}
