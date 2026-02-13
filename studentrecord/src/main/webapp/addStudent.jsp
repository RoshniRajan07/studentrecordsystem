<%@ page language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>

<h2>Add Student</h2>

<form action="MainServlet" method="post">

 
    <input type="hidden" name="operation" value="newRecord"/>

    Student Name:
    <input type="text" name="studentName" required/>
    <br><br>

    Roll Number:
    <input type="text" name="rollNumber" required/>
    <br><br>

    Class Name:
    <input type="text" name="className" required/>
    <br><br>

    Admission Date:
    <input type="date" name="admissionDate" required/>
    <br><br>

    Age:
    <input type="number" name="age" min="1" required/>
    <br><br>

    Remarks:
    <input type="text" name="remarks"/>
    <br><br>

    <input type="submit" value="Add Student"/>

</form>

</body>
</html>
