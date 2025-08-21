package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {

    private static final String URL  = "jdbc:mysql://localhost:3306/servlet";
    private static final String USER = "root";
    private static final String PASS = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL driver not found", e);
        }
    }

    public void addFood(String name, int quantity) {
        String sql = "INSERT INTO food(name, quantity) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, quantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting food", e);
        }
    }

    public List<Food> listFood() {
        String sql = "SELECT id, name, quantity FROM food ORDER BY id DESC";
        List<Food> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Food(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching food", e);
        }
        return list;
    }


        public void deleteFood(int id) {
        String sql = "DELETE FROM food WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting food", e);
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void updateFood(int id, String name, int quantity) {
        String sql = "UPDATE food SET name = ?, quantity = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, quantity);
            ps.setInt(3, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating food with id " + id, e);
        }
    }
}