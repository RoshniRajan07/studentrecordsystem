package com.wipro.student.servlets;

import java.io.IOException;
import java.util.List;

import com.wipro.student.bean.StudentBean;
import com.wipro.student.service.Administrator;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");
        Administrator admin = new Administrator();

        try {

      
            if (operation.equals("newRecord")) {

                StudentBean s = new StudentBean();

                s.setStudentName(request.getParameter("studentName"));
                s.setRollNumber(request.getParameter("rollNumber"));
                s.setClassName(request.getParameter("className"));
                s.setAge(Integer.parseInt(request.getParameter("age")));
                s.setRemarks(request.getParameter("remarks"));

               
                s.setAdmissionDate(
                    java.sql.Date.valueOf(
                        request.getParameter("admissionDate")));

                String result = admin.addRecord(s);

                if (result.equals("FAIL") ||
                    result.contains("INVALID") ||
                    result.equals("ALREADY EXISTS"))
                    response.sendRedirect("error.html");
                else
                    response.sendRedirect("success.html");
            }

      
            else if (operation.equals("viewRecord")) {

                StudentBean s =
                    admin.viewRecord(
                        request.getParameter("roll"),
                        java.sql.Date.valueOf(
                            request.getParameter("date")));

                request.setAttribute("student", s);

                RequestDispatcher rd =
                    request.getRequestDispatcher("displayStudent.jsp");

                rd.forward(request, response);
            }

        
            else if (operation.equals("viewAllRecords")) {

                List<StudentBean> list =
                    admin.viewAllRecords();

                request.setAttribute("list", list);

                RequestDispatcher rd =
                    request.getRequestDispatcher("displayAllStudents.jsp");

                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
