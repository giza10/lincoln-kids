package com.appspot.lincoln_kids.calcgame;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	QuestionSet[] questionSets = new QuestionSet[10];
    	for(int i=0; i<10; i++) {
    		questionSets[i] = generateQuestion();
    	}
    	
        req.setAttribute("questionSet", questionSets);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/WEB-INF/calcgame/main.jsp");
        rd.forward(req, resp);
    }

    QuestionSet generateQuestion() {
        Random rnd = new Random();
        int arg1 = rnd.nextInt(10);
        int arg2 = rnd.nextInt(10);

        QuestionSet set = new QuestionSet();
        set.setQuestion(new String(arg1 + " + " + arg2 + " = ?"));
//        set.ans1 = 1;
//        set.ans2 = 2;
//        set.ans3 = 3;
//        set.ans4 = 4;
//        set.correctAnsIdx = 2;

        return set;
    }
}
