package com.appspot.lincoln_kids;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
    private static final String GOOGLE_URL = "https://www.google.com/accounts/o8/id";
    private static final String YAHOO_URL = "yahoo.co.jp";
    private static final String MIXI_URL = "https://mixi.jp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /* OpenID認証サーバーからリダイレクトされるトップ画面のURLを作成する */
        String continuePage = createServerStringBuffer(req.getScheme(),
                req.getServerName(), req.getServerPort()).append("/index")
                .toString();

        /* OpenID情報をリクエスト属性に保存する */
        req.setAttribute("google", createOpenIdUrl(continuePage, GOOGLE_URL));
        req.setAttribute("yahoo", createOpenIdUrl(continuePage, YAHOO_URL));
        req.setAttribute("mixi", createOpenIdUrl(continuePage, MIXI_URL));

        /* ログイン画面を表示する */
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/WEB-INF/login.jsp");
        rd.forward(req, resp);
    }

    /* サイトのルートパスを返す（例：http://smart-games.appspot.com/） */
    /* (org.apache.struts.util.RequestUtilsより引用) */
    private StringBuffer createServerStringBuffer(String scheme, String server,
            int port) {
        StringBuffer url = new StringBuffer();
        if (port < 0) {
            port = 80; // Work around java.net.URL bug
        }
        url.append(scheme);
        url.append("://");
        url.append(server);
        if ((scheme.equals("http") && (port != 80))
                || (scheme.equals("https") && (port != 443))) {
            url.append(':');
            url.append(port);
        }
        return url;
    }

    /* OpenID情報を含むURLを作成する */
    private String createOpenIdUrl(String continuePage, String openIdentifier)
            throws UnsupportedEncodingException {
        return "/loginhandler?continue="
                + URLEncoder.encode(continuePage, "UTF-8")
                + "&openid_identifier="
                + URLEncoder.encode(openIdentifier, "UTF-8");
    }
}
