package com.example;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/food/updateFood")
public class UpdateFoodServlet extends HttpServlet {
    private final FoodDAO dao = new FoodDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        dao.updateFood(id, name, quantity);

        req.getSession().setAttribute("msg", "Food updated successfully.");
        resp.sendRedirect(req.getContextPath() + "/food");
    }
}