package com.restdemo.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/addNewDoctor")
public class AddNewDoctorServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AddNewDoctorServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        RequestDispatcher view;

        //TODO attributes
//        req.setAttribute();

        view = getServletContext().getRequestDispatcher("/addNewDoctor.jsp");
        view.forward(req, resp);
    }
}
