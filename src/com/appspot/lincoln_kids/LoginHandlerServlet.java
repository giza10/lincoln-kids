package com.appspot.lincoln_kids;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class LoginHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /* 入力されたOpenID情報を取得する */
        String continuePage = req.getParameter("continue");
        String openidIdentifier = req.getParameter("openid_identifier");

        /* OpenID認証サーバー情報を取得する */
        String authDomain = continuePage.substring(0,
                continuePage.lastIndexOf("/"));
        Set<String> attributesRequest = new HashSet<String>();

        /* OpenID認証サーバーにリダイレクトする */
        UserService userService = UserServiceFactory.getUserService();
        String createdUrl = userService.createLoginURL(continuePage,
                authDomain, openidIdentifier, attributesRequest);
        resp.sendRedirect(createdUrl);
    }
}
