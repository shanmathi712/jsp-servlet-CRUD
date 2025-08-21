package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/food/edit")
public class EditFoodServlet extends HttpServlet {
    private final FoodDAO dao = new FoodDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                // fetch the food from DB
                for (Food f : dao.listFood()) {
                    if (f.getId() == id) {
                        req.setAttribute("food", f);
                        req.getRequestDispatcher("/editFood.jsp").forward(req, resp);
                        return;
                    }
                }
                req.getSession().setAttribute("msg", "Food not found.");
            } catch (NumberFormatException e) {
                req.getSession().setAttribute("msg", "Invalid food ID.");
            }
        }
        resp.sendRedirect(req.getContextPath() + "/food");
    }
}
