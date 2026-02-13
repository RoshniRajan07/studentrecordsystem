<%@ page import="com.wipro.student.bean.StudentBean" %>

<html>
<head>
    <title>Student Details</title>
</head>
<body>

<%
StudentBean s = (StudentBean) request.getAttribute("student");

if(s == null){
%>

<h3>No matching records exists! Please try again!</h3>

<%
}else{
%>

<h2>Student Details</h2>

ID: <%= s.getStudentId() %><br><br>
Name: <%= s.getStudentName() %><br><br>
Roll: <%= s.getRollNumber() %><br><br>
Class: <%= s.getClassName() %><br><br>
Admission Date: <%= s.getAdmissionDate() %><br><br>
Age: <%= s.getAge() %><br><br>
Remarks: <%= s.getRemarks() %><br><br>

<%
}
%>

</body>
</html>
