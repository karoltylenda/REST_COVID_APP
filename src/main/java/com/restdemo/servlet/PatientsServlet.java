package com.restdemo.servlet;

import com.restdemo.service.PatientService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patients")
public class PatientsServlet extends HttpServlet {

    @Inject
    private PatientService patientService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setRequestDispatcher(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer patientId = Integer.valueOf(req.getParameter("patientId"));
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        Integer pesel = Integer.valueOf(req.getParameter("pesel"));
        Integer doctorId = Integer.valueOf(req.getParameter("doctorId"));

        patientService.update(patientId, name, lastName, pesel, doctorId);

        setRequestDispatcher(req, resp);
    }
    
    private void setRequestDispatcher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("patients", patientService.getAll());
        RequestDispatcher view = getServletContext().getRequestDispatcher("/patients_view.jsp");
        view.forward(req, resp);
    }
}
