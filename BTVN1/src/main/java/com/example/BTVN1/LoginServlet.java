package com.example.BTVN1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login", "/home"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String baoLoi = "";
       if(userName.equals(null)){
           baoLoi = baoLoi + "Login fail";
           request.setAttribute("baoLoi", baoLoi);
           request.getRequestDispatcher("/view/login.jsp").forward(request, response);
       }
        if(password.equals(null)){
            baoLoi = baoLoi + "Login fail";
            request.setAttribute("baoLoi", baoLoi);
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
        if (!userName.equals("HangNT169")) {
            baoLoi = baoLoi + "Login fail";
            request.setAttribute("baoLoi", baoLoi);
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
        if (!password.equals("123456")) {
            baoLoi = baoLoi + "Login fail";
            request.setAttribute("baoLoi", baoLoi);
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
        if (userName.equals("HangNT169") && password.equals("123456")) {
            System.out.println("Hihi");
            request.setAttribute("userName", userName);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/view/home.jsp").forward(request, response);
        }
    }
}
