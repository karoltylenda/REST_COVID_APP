package com.restdemo.servlet;

import com.restdemo.service.AddressService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addNewAddress")
public class AddNewAddressServlet extends HttpServlet {

    @Inject
    private AddressService addressService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher view;

        String city = req.getParameter("city");
        String district = req.getParameter("district");
        String postalCode = req.getParameter("postalCode");
        String street = req.getParameter("street");
        String streetNr = req.getParameter("streetNr");
        String localNr = req.getParameter("localNr");

        addressService.addAddress(city, district, postalCode, street, streetNr, localNr);

        view = getServletContext().getRequestDispatcher("/index.html");
        view.forward(req, resp);
    }
}
