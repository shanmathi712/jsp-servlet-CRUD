<%@ page import="com.example.Food" %>
<%
    Food food = (Food) request.getAttribute("food");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Food</title>
</head>
<body>
    <h2>Edit Food</h2>

    <form action="updateFood" method="post">
    <input type="hidden" name="id" value="<%= food.getId() %>">

    Name: <input type="text" name="name" value="<%= food.getName() %>"><br>
    Quantity: <input type="number" name="quantity" value="<%= food.getQuantity() %>"><br>

    <input type="submit" value="Update">
    </form>
</body>
</html>