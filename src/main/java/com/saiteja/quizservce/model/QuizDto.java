package com.saiteja.quizservce.model;

import lombok.Data;

@Data
public class QuizDto {
	
	private String categoryName;
	private int numQuestions;
	private String title;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getNumQuestions() {
		return numQuestions;
	}
	public void setNumQuestions(int numQuestions) {
		this.numQuestions = numQuestions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "QuizDto [categoryName=" + categoryName + ", numQuestions=" + numQuestions + ", title=" + title + "]";
	}
	
	

}
