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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/addNewDoctor")
public class AddNewDoctorServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AddNewDoctorServlet.class.getName());

    @Inject
    private DoctorService doctorService;

    @Inject
    private PatientService patientService;

    @Inject
    private AddressService addressService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        RequestDispatcher view;

        req.setAttribute("patients", patientService.getAll());
        req.setAttribute("addresses", addressService.getAll());

        view = getServletContext().getRequestDispatcher("/addNewDoctor.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher view;

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        Integer pesel = Integer.valueOf(req.getParameter("pesel"));
        boolean isDoctor = Boolean.parseBoolean(req.getParameter("isDoctor"));
        Integer addressId = Integer.valueOf(req.getParameter("addressId"));

        doctorService.addDoctor(name, lastName, pesel, isDoctor, addressId);

        view = getServletContext().getRequestDispatcher("/index.html");
        view.forward(req, resp);
    }
}
