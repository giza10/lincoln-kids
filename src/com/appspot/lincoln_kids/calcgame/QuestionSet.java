package com.appspot.lincoln_kids.calcgame;

public class QuestionSet {
	private String question;
	private int[] answerList;
	private int correctAnsIdx;

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setAnswerList(int[] answerList) {
		this.answerList = answerList;
	}

	public void setCorrectAnsIdx(int correctAnsIdx) {
		this.correctAnsIdx = correctAnsIdx;
	}

	public String getQuestion() {
		return question;
	}

	public int[] getAnswerList() {
		return answerList;
	}

	public int getCorrectAnsIdx() {
		return correctAnsIdx;
	}
}
