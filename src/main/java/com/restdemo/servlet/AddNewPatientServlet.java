package com.restdemo.servlet;

import com.restdemo.service.AddressService;
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

@WebServlet("/addNewPatient")
public class AddNewPatientServlet extends HttpServlet {

    @Inject
    private DoctorService doctorService;

    @Inject
    private AddressService addressService;

    @Inject
    private PatientService patientService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("doctors", doctorService.getAll());
        req.setAttribute("addresses", addressService.getAll());

        RequestDispatcher view = getServletContext().getRequestDispatcher("/addNewPatient.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        Integer pesel = Integer.valueOf(req.getParameter("pesel"));
        Integer doctorId = Integer.valueOf(req.getParameter("doctorId"));
        Integer addressId = Integer.valueOf(req.getParameter("addressId"));

        patientService.addPatient(name, lastName, pesel, doctorId, addressId);

        RequestDispatcher view = getServletContext().getRequestDispatcher("/index.html");
        view.forward(req, resp);
    }
}
