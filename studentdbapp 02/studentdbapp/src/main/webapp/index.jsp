<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Food App</title>
</head>
<body>
  <h2>Food App</h2>

<button type="button" id="btnJs">View Food</button>
<button type="button" id="btnJsadd">Add Food</button>
<button type="button" id="btnDelete">Delete Food</button>
<button type="button" id="btnUpdate">Update Food</button>

  <script>
    document.getElementById('btnJs').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/food';
    });

    document.getElementById('btnJsadd').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/addFood.jsp';
    });

    document.getElementById('btnDelete').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/food';
    });

    document.getElementById('btnUpdate').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/food';
    });
  </script>
</body>
</html>