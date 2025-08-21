<%@ page import="java.util.*,com.example.Food" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Food List</title>
</head>
<body>
  <h2>Food Items</h2>
<%
    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
  %>
      <p style="color:red;"><%= msg %></p>
  <%
      session.removeAttribute("msg");
    }
  %>

  <%
    List<Food> foods = (List<Food>) request.getAttribute("foods");
    if (foods == null || foods.isEmpty()) {
  %>
      <p>No food items yet.</p>
  <%
    } else {
  %>
      <table border="1" cellpadding="6" cellspacing="0">
        <tr>
          <th>ID</th><th>Name</th><th>Quantity</th><th>Edit/Delete</th>
        </tr>
        <%
          for (Food f : foods) {
        %>
            <tr>
              <td><%= f.getId() %></td>
              <td><%= f.getName() %></td>
              <td><%= f.getQuantity() %></td>
              <td>
                <a href="<%= request.getContextPath() %>/food/edit?id=<%= f.getId() %>">Edit</a>

                &nbsp;|&nbsp;
          <a href="<%= request.getContextPath() %>/food/delete?id=<%= f.getId() %>"
            onclick="return confirm('Are you sure you want to delete this food?');">
            Delete
          </a>
        </td> 
            </tr>
        <%
          }
        %>
      </table>
  <%
    }
  %>

  <p>
<a href="<%= request.getContextPath() %>/addFood.jsp">Add Food</a>
<a href="<%= request.getContextPath() %>/">Home</a>
  </p>
</body>
</html>