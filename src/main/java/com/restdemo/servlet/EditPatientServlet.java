package com.restdemo.servlet;

import com.restdemo.dto.PatientDto;
import com.restdemo.service.DoctorService;
import com.restdemo.service.PatientService;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editpatient")
public class EditPatientServlet extends HttpServlet {

    @Inject
    private PatientService patientService;

    @Inject
    private DoctorService doctorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Integer patientId = Integer.valueOf(req.getParameter("patientId"));
        req.setAttribute("patient", patientService.getById(patientId));
        req.setAttribute("doctors", doctorService.getAll());
        PatientDto patientDto = patientService.getById(patientId);

        RequestDispatcher view = getServletContext().getRequestDispatcher("/page/editPatient.jsp");
        view.forward(req,resp);
    }
}
