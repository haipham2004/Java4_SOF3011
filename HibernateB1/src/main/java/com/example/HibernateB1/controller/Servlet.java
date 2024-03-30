package com.example.HibernateB1.controller;

import com.example.HibernateB1.entity.Category;
import com.example.HibernateB1.entity.Product;
import com.example.HibernateB1.repository.ProductRepository;
import com.example.HibernateB1.request.ProductRequest;
import com.example.HibernateB1.service.ProductServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = {
        "/category/hien-thi",
        "/category/detail",
        "/category/delete",
        "/category/view-update",
        "/category/update",
        "/view-add",
        "/category/add"
})
public class Servlet extends HttpServlet {
    ProductServiceImp serviceImp=new ProductServiceImp();
    ProductRepository repo=new ProductRepository();
    List<Product> listP=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.getAll(request, response);
        }else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        }else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        }
    }




    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        }else if (uri.contains("update")) {
            this.update(request, response);
        }
    }



    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        ProductRequest proRductRequests = new ProductRequest();
        BeanUtils.populate(proRductRequests, request.getParameterMap());
        int category = Integer.parseInt(request.getParameter("category.id"));
        Category categorys = new Category();
        categorys.setId(category);
        proRductRequests.setCategory(categorys);
        System.out.println("Minh tam: "+proRductRequests);
        serviceImp.add2(proRductRequests);
        response.sendRedirect("/category/hien-thi");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ProductRequest proRductRequests = new ProductRequest();
        BeanUtils.populate(proRductRequests, request.getParameterMap());
        int id = Integer.parseInt(request.getParameter("id"));
        int category = Integer.parseInt(request.getParameter("category.id"));
        Category categorys = new Category();
        categorys.setId(category);
        proRductRequests.setCategory(categorys);
        proRductRequests.setId(id);
        System.out.println("Minh tam update: "+proRductRequests+"id update: "+id);
        serviceImp.update2(proRductRequests);
        response.sendRedirect("/category/hien-thi");
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/AddProduct.jsp").forward(request,response);
    }
    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Product prd=repo.getOne(id);
        request.setAttribute("prd",prd);
        request.getRequestDispatcher("/view/UpdateProduct.jsp").forward(request,response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listP=repo.getAll();
        request.setAttribute("listP",listP);
        request.getRequestDispatcher("/view/List.jsp").forward(request,response);
    }
}
