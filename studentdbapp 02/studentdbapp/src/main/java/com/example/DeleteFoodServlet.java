package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/food/delete")
public class DeleteFoodServlet extends HttpServlet {
    private final FoodDAO dao = new FoodDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                dao.deleteFood(id);
                req.getSession().setAttribute("msg", "Food deleted successfully.");
            } catch (NumberFormatException e) {
                req.getSession().setAttribute("msg", "Invalid food ID.");
            }
        }
        resp.sendRedirect(req.getContextPath() + "/food");
    }
}