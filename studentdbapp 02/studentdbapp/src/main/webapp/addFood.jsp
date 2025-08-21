<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Food</title>
</head>
<body>
  <h2>Add Food</h2>

  <%
    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
  %>
      <p style="color:red;"><%= msg %></p>
  <%
      session.removeAttribute("msg");
    }
  %>

<form method="post" action="<%= request.getContextPath() %>/food/add">
    <label>Name: <input type="text" name="name" required></label><br><br>
    <label>Quantity: <input type="number" name="quantity" min="1" required></label><br><br>
    <button type="submit">Save</button>
  </form>

<a href="<%= request.getContextPath() %>/">Home</a>
</body>
</html>