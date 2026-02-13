<%@ page language="java" %>
<html>
<head>
    <title>View Student</title>
</head>
<body>

<h2>View Student Record</h2>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="viewRecord"/>

Roll Number: <input type="text" name="roll"/><br><br>
Admission Date: <input type="date" name="date"/><br><br>

<input type="submit" value="Search"/>

</form>

</body>
</html>
