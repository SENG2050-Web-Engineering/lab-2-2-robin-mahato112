package com.unix.enrolment.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        String username = (session == null) ? null : (String) session.getAttribute("username");

        if (username == null || username.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/session-expired");
            return;
        }

        chain.doFilter(request, response);
    }
}
