package com.appspot.lincoln_kids.calcgame;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MainServlet extends HttpServlet {

	private final int NUM_OF_QUESTION = 10;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		QuestionGenerator generator = new QuestionGenerator();
		QuestionSet[] questionSets = new QuestionSet[NUM_OF_QUESTION];
		for (int i = 0; i < NUM_OF_QUESTION; i++) {
			questionSets[i] = generator.generateQuestion();
		}

		req.setAttribute("questionSet", questionSets);

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/WEB-INF/calcgame/main.jsp");
		rd.forward(req, resp);
	}
}
