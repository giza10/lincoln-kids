package com.appspot.smartgames.juststop;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.lincoln_kids.PMF;
import com.google.appengine.api.users.User;


@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /* ログインしていなければ登録しない */
        User user = (User) req.getAttribute("user");
        if (user == null) {
            return;
        }
        /* Over Runしていたら登録しない */
        double leftLength = Double.parseDouble(req.getParameter("leftLength"));
        if (leftLength < 0) {
            return;
        }

        /* スコアエンティティを登録する */
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            String accountId = user.getFederatedIdentity();
            if (accountId == null) {
                accountId = user.getUserId();
            }
            String nickname = (String) req.getAttribute("nickname");
            Calendar calendar = Calendar.getInstance(TimeZone
                    .getTimeZone("Asia/Tokyo"));
            Date registerDate = calendar.getTime();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            double rankValue = year * 1000000 + month * 10000 + leftLength;
            Score score = new Score(accountId, nickname, registerDate,
                    rankValue);
            pm.makePersistent(score);
        } finally {
            pm.close();
        }
    }
}
