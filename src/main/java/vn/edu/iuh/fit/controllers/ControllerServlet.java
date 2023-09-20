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
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.Log;
import vn.edu.iuh.fit.repositories.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import vn.edu.iuh.fit.repositories.LogRepository;
import vn.edu.iuh.fit.repositories.RoleRepository;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private AccountRepository accountRepository;
    private LogRepository logRepository;
    private RoleRepository roleRepository;

    private int log_id;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");
        this.req = req;
        this.resp = resp;
        if (action.equals("login")){
            if (handleLogin())
                req.getRequestDispatcher("/user.jsp").forward(req, resp);
        } else if (action.equals("logout")){
            handleLogout();
        } else if(action.equals("View As Admin")){
            handleViewAdmin();

        }

    }


    private boolean handleLogin() throws JsonProcessingException, RemoteException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        accountRepository = new AccountRepository();
        Account account = accountRepository.checkAccount(email,password);
        String json = convertObjectToJson(account);
        req.setAttribute("account", json);
        if (account==null)
            return false;
        else{
            Log log = new Log(account);
            req.setAttribute("log_account", log.getAccount().getAccount_id());
            logRepository = new LogRepository();
            log_id = logRepository.addLog(log);
            return true;
        }
    }

    private void handleLogout() throws ServletException, IOException {
        logRepository.updateLogoutTime(log_id);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void handleViewAdmin() throws IOException, ServletException {
        List<Account> listAcc = new ArrayList<>();
        listAcc = accountRepository.getAllAccountActive();
        String json = convertObjectToJson(listAcc);
        req.setAttribute("listAcc", json);
        System.out.println(json);
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    private String convertObjectToJson(Object o) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(o);
        return json;
    }


}