package vn.edu.iuh.fit.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.Log;
import vn.edu.iuh.fit.services.AccountServices;
import vn.edu.iuh.fit.services.LogServices;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private AccountServices accountServices;
    private LogServices logServices;
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
        if (action.equals("login")) {
            if (handleLogin()) req.getRequestDispatcher("/user.jsp").forward(req, resp);
        } else if (action.equals("logout")) {
            handleLogout();
        } else if (action.equals("View As Admin")) {
            handleViewAdmin();
        }

    }

    private boolean handleLogin() throws JsonProcessingException, RemoteException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        accountServices = new AccountServices();
        Account account = accountServices.checkAccount(email, password);
        String json = convertObjectToJson(account);
        req.setAttribute("account", json);
        if (account == null) return false;
        else {
            Log log = new Log(account.getAccountID());
            req.setAttribute("log_account", log.getAccountID());
            logServices = new LogServices();
            log_id = logServices.insertLog(log);
            return true;
        }
    }

    private void handleLogout() throws ServletException, IOException {
        logServices.updateLogoutTime(log_id);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void handleViewAdmin() throws IOException, ServletException {
        List<Account> listAcc = new ArrayList<>();
        listAcc = accountServices.getAllAccountActive();
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