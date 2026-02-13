<%@ page language="java" %>
<html>
<head>
    <title>View All Students</title>
</head>
<body>

<h2>View All Student Records</h2>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="viewAllRecords"/>

<input type="submit" value="View All"/>

</form>

</body>
</html>
