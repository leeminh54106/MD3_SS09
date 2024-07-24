package com.example.ss09;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoProduct", value = "/display-discount")
public class DoProduct extends HttpServlet {
    private String message;

    public void init() {
        message = "Mau do";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
     request.setCharacterEncoding("UTF-8");
     response.setCharacterEncoding("UTF-8");

     String description = request.getParameter("productDescription");
     double price = Double.parseDouble(request.getParameter("price"));
     double discountPercent = Double.parseDouble(request.getParameter("dicountpercent"));

     double discountAmount = discountPercent*price*0.01;
     double discountPrice = price - discountAmount;
     request.setAttribute("description", description);
     request.setAttribute("price", price);
     request.setAttribute("discountPercent", discountPercent);
     request.setAttribute("discountAmout", discountAmount);
     request.setAttribute("discountPrice", discountPrice);

     request.getRequestDispatcher("Result.jsp").forward(request,response);

    }

    public void destroy() {
    }
}