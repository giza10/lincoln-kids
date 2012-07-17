package com.appspot.lincoln_kids.calcgame;

import java.util.Random;

public class QuestionGenerator {
	private final int NUM_OF_ANSWER_LIST = 4;

	public QuestionSet generateQuestion() {
		Random rnd = new Random();
		int arg1 = rnd.nextInt(9) + 1;
		int arg2 = rnd.nextInt(9) + 1;
		int correctAnsIdx = 0;
		int answers[] = new int[NUM_OF_ANSWER_LIST];
		int correctAns = arg1 + arg2;

		// Temporary
		answers[0] = correctAns;
		answers[1] = correctAns - 1;
		answers[2] = correctAns + 1;
		answers[3] = correctAns + 1 + arg1;
		shuffle(answers);
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == correctAns) {
				correctAnsIdx = i;
				break;
			}
		}

		QuestionSet set = new QuestionSet();
		set.setQuestion(new String(arg1 + " + " + arg2 + " = ?"));
		set.setAnswerList(answers);
		set.setCorrectAnsIdx(correctAnsIdx);

		return set;
	}

	public static void shuffle(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int t = (int) (Math.random() * i);

			int tmp = array[i];
			array[i] = array[t];
			array[t] = tmp;
		}
	}
}
