package com.example.Bai1.FormWeb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login", "/ket-qua"

})

//Value:đường dẫn
//bat buoc có /
// Có 4 loại:
//Get: hiển thị, post: Xử lí form
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Chuyển trang
        //C1:

        String mess = "Hai Pham YKA";
        request.setAttribute("userName", mess);
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
//        response.sendRedirect("/view/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        request.setAttribute("userName",username);
        request.setAttribute("password",password);
        request.getRequestDispatcher("/view/KetQua.jsp").forward(request,response);
    }
}
