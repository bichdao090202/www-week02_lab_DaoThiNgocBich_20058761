//package vn.edu.iuh.fit.controllers;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import vn.edu.iuh.fit.repositories.AccountRepository;
//
//import java.io.IOException;
//
//@WebServlet(name = "/ControllerServlet", value = "/hello")
//public class ControllerServlet extends HttpServlet {
//
//    public ControllerServlet(String action) {
//
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//        AccountRepository ac = new AccountRepository();
//        System.out.println(ac.getAllAccountActive());
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user.jsp");
//        dispatcher.forward(request, response);
//    }
////    @Override
////    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        System.out.println("sadjn");
////
////    }
//}
package vn.edu.iuh.fit.controllers;

import java.io.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.ConnectionDB.ConnectionDB;
import vn.edu.iuh.fit.repositories.AccountRepository;
@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        System.out.println("ac.getAllAccountActive()");
        AccountRepository ac = new AccountRepository();
        System.out.println(ac.getAllAccountActive());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/user.jsp");
        dispatcher.forward(req, resp);
    }

}