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
        int arg1 = rnd.nextInt(9) + 1;
        int arg2 = rnd.nextInt(9) + 1;
        int correctAnsIdx = rnd.nextInt(4);
        int answers[] = new int[4];
        int correctAns = arg1 + arg2;

        // Temporary
        answers[correctAnsIdx] = correctAns;
        answers[(correctAnsIdx+1)%4] = correctAns - 1;
        answers[(correctAnsIdx+2)%4] = correctAns + 1;
        answers[(correctAnsIdx+3)%4] = correctAns + arg1;

        QuestionSet set = new QuestionSet();
        set.setQuestion(new String(arg1 + " + " + arg2 + " = ?"));
        set.setAns1(answers[0]);
        set.setAns2(answers[1]);
        set.setAns3(answers[2]);
        set.setAns4(answers[3]);
        set.setCorrectAnsIdx(correctAnsIdx);

        return set;
    }
}
