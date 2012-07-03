package com.appspot.lincoln_kids.calcgame;

public class QuestionSet {
	private String question;
	private int ans1;
	private int ans2;
	private int ans3;
	private int ans4;
	private int correctAnsIdx;
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void setAns1(int ans1) {
		this.ans1 = ans1;
	}
	public void setAns2(int ans2) {
		this.ans2 = ans2;
	}
	public void setAns3(int ans) {
		this.ans3 = ans;
	}
	public void setAns4(int ans) {
		this.ans4 = ans;
	}
	public void setCorrectAnsIdx(int correctAnsIdx) {
		this.correctAnsIdx = correctAnsIdx;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public int getAns1() { return ans1; }
	public int getAns2() { return ans2; }
	public int getAns3() { return ans3; }
	public int getAns4() { return ans4; }
	public int getCorrectAnsIdx() { return correctAnsIdx; }
}
