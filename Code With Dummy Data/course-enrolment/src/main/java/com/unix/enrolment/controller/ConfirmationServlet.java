package com.unix.enrolment.controller;

import com.unix.enrolment.model.Semester;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ConfirmationServlet", urlPatterns = {"/confirmation"})
public class ConfirmationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Semester semester = (Semester) session.getAttribute("selectedSemester");
        if (semester == null) {
            resp.sendRedirect(req.getContextPath() + "/semesters");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/views/confirmation.jsp").forward(req, resp);
    }
}
