package com.unix.enrolment.controller;

import com.unix.enrolment.dao.DummySemesterDAO;
import com.unix.enrolment.dao.SemesterDAO;
import com.unix.enrolment.model.Semester;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "SemesterServlet", urlPatterns = {"/semesters"})
public class SemesterServlet extends HttpServlet {

    private static final SemesterDAO semesterDAO = new DummySemesterDAO(); 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Semester> semesters = semesterDAO.findAll();
        req.setAttribute("semesters", semesters);

        if (!semesterDAO.hasAnyOpenSemester()) {
            req.getRequestDispatcher("/WEB-INF/views/no_open_semesters.jsp").forward(req, resp);
            return;
        }

        req.getRequestDispatcher("/WEB-INF/views/semesters.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String semesterId = req.getParameter("semesterId");

        if (semesterId == null || semesterId.trim().isEmpty()) {
            req.setAttribute("error", "Please select an open semester to continue.");
            doGet(req, resp);
            return;
        }

        Optional<Semester> chosen = semesterDAO.findById(semesterId);
        if (!chosen.isPresent()) {
            req.setAttribute("error", "Selected semester was not found.");
            doGet(req, resp);
            return;
        }

        if (!chosen.get().isOpen()) {
            req.setAttribute("error", "That semester is not open for enrolment.");
            doGet(req, resp);
            return;
        }

        HttpSession session = req.getSession(false);
        session.setAttribute("selectedSemester", chosen.get());
        session.removeAttribute("enrolledCourses");

        resp.sendRedirect(req.getContextPath() + "/enrol");
    }
}
