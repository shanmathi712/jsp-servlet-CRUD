package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/food/add")
public class AddFoodServlet extends HttpServlet {
    private final FoodDAO dao = new FoodDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String quantityStr = req.getParameter("quantity");

        if (name == null || name.isBlank() || quantityStr == null || quantityStr.isBlank()) {
            req.getSession().setAttribute("msg", "Name and Quantity are required.");
            resp.sendRedirect(req.getContextPath() + "/addFood.jsp");
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityStr);
            dao.addFood(name.trim(), quantity);
            // redirect to list after insert (PRG pattern)
            resp.sendRedirect(req.getContextPath() + "/food");
        } catch (NumberFormatException nfe) {
            req.getSession().setAttribute("msg", "Quantity must be a number.");
            resp.sendRedirect(req.getContextPath() + "/addFood.jsp");
        }
    }
}