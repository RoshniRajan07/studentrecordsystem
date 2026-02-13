<%@ page import="java.util.List" %>
<%@ page import="com.wipro.student.bean.StudentBean" %>

<html>
<head>
    <title>All Students</title>
</head>
<body>

<%
List<StudentBean> list =
    (List<StudentBean>) request.getAttribute("list");

if(list == null || list.isEmpty()){
%>

<h3>No records available!</h3>

<%
}else{
%>

<h2>All Student Records</h2>

<%
for(StudentBean s : list){
%>

-----------------------------------<br>
ID: <%= s.getStudentId() %><br>
Name: <%= s.getStudentName() %><br>
Roll: <%= s.getRollNumber() %><br>
Class: <%= s.getClassName() %><br>
Age: <%= s.getAge() %><br>
Remarks: <%= s.getRemarks() %><br>

<%
}
}
%>

</body>
</html>
