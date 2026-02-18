package com.unix.enrolment.controller;

import com.unix.enrolment.dao.CourseDAO;
import com.unix.enrolment.dao.DummyCourseDAO;
import com.unix.enrolment.model.Course;
import com.unix.enrolment.model.Semester;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EnrolServlet", urlPatterns = {"/enrol"})
public class EnrolServlet extends HttpServlet {

    private static final CourseDAO courseDAO = new DummyCourseDAO(); 

    private static final int MAX_UNITS = 12; 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Semester semester = (Semester) session.getAttribute("selectedSemester");
        if (semester == null) {
            // user didn't choose a semester
            resp.sendRedirect(req.getContextPath() + "/semesters");
            return;
        }

        List<Course> courses = courseDAO.findCoursesOffered(semester.getId());
        req.setAttribute("courses", courses);
        req.setAttribute("semester", semester);

        req.getRequestDispatcher("/WEB-INF/views/enrol.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Semester semester = (Semester) session.getAttribute("selectedSemester");
        if (semester == null) {
            resp.sendRedirect(req.getContextPath() + "/semesters");
            return;
        }

        String[] selectedCodes = req.getParameterValues("courseCode");
        if (selectedCodes == null || selectedCodes.length == 0) {
            req.setAttribute("error", "Select at least one course to enrol.");
            doGet(req, resp);
            return;
        }

        List<Course> selectedCourses = new ArrayList<>();
        int totalUnits = 0;

        for (String code : selectedCodes) {
            Course c = courseDAO.findByCode(semester.getId(), code);
            if (c != null) {
                selectedCourses.add(c);
                totalUnits += c.getUnits();
            }
        }

        if (selectedCourses.isEmpty()) {
            req.setAttribute("error", "Your selection was invalid. Please try again.");
            doGet(req, resp);
            return;
        }

        
        if (totalUnits > MAX_UNITS) {
            req.setAttribute("error", "Enrolment failed: maximum " + MAX_UNITS + " units allowed (you selected " + totalUnits + ").");
            doGet(req, resp);
            return;
        }

        // Mock-up success: store in session and go to confirmation
        session.setAttribute("enrolledCourses", selectedCourses);
        resp.sendRedirect(req.getContextPath() + "/confirmation");
    }
}
