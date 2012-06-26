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

        String question = createQuestion();
        req.setAttribute("Question", question);
        int ans1 = 15;
        int ans2 = 20;
        int ans3 = 25;
        int ans4 = 30;
        req.setAttribute("ans1", ans1);
        req.setAttribute("ans2", ans2);
        req.setAttribute("ans3", ans3);
        req.setAttribute("ans4", ans4);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/WEB-INF/calcgame/main.jsp");
        rd.forward(req, resp);
    }

    String createQuestion() {
        Random rnd = new Random();
        int arg1 = rnd.nextInt(10);
        int arg2 = rnd.nextInt(10);

        return new String(arg1 + " + " + arg2 + " = ");
    }
}
