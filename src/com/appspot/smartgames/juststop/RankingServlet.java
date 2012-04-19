package com.appspot.smartgames.juststop;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.lincoln_kids.PMF;

@SuppressWarnings("serial")
public class RankingServlet extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /* 今月分のみ取得する検索条件を用意する */
        Calendar calendar = Calendar.getInstance(TimeZone
                .getTimeZone("Asia/Tokyo"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        req.setAttribute("date", year + "/" + (month + 1));
        double fromRankValue = year * 1000000 + month * 10000;
        double toRankValue = fromRankValue + 10000;

        /* 今月の上位100傑を検索する */
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            Query query = pm.newQuery(Score.class);
            query.setFilter("rankValue >= :fromRankValue && rankValue < :toRankValue");
            query.setOrdering("rankValue ASC");
            query.setRange(0, 100);
            List<Score> scores = (List<Score>) query.execute(fromRankValue,
                    toRankValue);
            pm.detachCopyAll(scores);
            req.setAttribute("scores", scores);
        } finally {
            pm.close();
        }

        /* ランキングJSPを表示する */
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/WEB-INF/juststop/ranking.jsp");
        rd.forward(req, resp);
    }
}
