package com.wipro.student.dao;

import java.sql.Connection;
import java.util.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.wipro.student.bean.StudentBean;
import com.wipro.student.util.DBUtil;
import java.text.DateFormat;

public class StudentDAO {

    public String createRecord(StudentBean bean) {

        try {
            Connection connection = DBUtil.getDBConnection();

            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO STUDENT_TB VALUES(?,?,?,?,?,?,?)");

            ps.setString(1, bean.getStudentId());
            ps.setString(2, bean.getStudentName());
            ps.setString(3, bean.getRollNumber());
            ps.setString(4, bean.getClassName());
            ps.setDate(5, new java.sql.Date(
                    bean.getAdmissionDate().getTime()));

            ps.setInt(6, bean.getAge());
            ps.setString(7, bean.getRemarks());

            int rs = ps.executeUpdate();

            if (rs > 0) {
                return bean.getStudentId();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Fail";
    }

    public StudentBean fetchRecord(String rollNumber, Date admissionDate)
 {

        try {
            Connection connection = DBUtil.getDBConnection();
            PreparedStatement ps = connection.prepareStatement(
            		"SELECT * FROM STUDENT_TB WHERE ROLLNUMBER=? AND ADMISSION_DATE=?");



            ps.setString(1, rollNumber);
            ps.setDate(2, new java.sql.Date(
                    admissionDate.getTime()));


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                StudentBean s = new StudentBean();

                s.setStudentId(rs.getString(1));
                s.setStudentName(rs.getString(2));
                s.setRollNumber(rs.getString(3));
                s.setClassName(rs.getString(4));
                s.setAdmissionDate(rs.getDate(5));
                s.setAge(rs.getInt(6));
                s.setRemarks(rs.getString(7));

                return s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean recordExists(String rollNumber, java.util.Date date) {

    	StudentBean s = fetchRecord(rollNumber, date);


        if (s != null)
            return true;

        return false;
    }

    public List<StudentBean> fetchAllRecords() {

        ArrayList<StudentBean> list = new ArrayList<StudentBean>();

        try {
            Connection con = DBUtil.getDBConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM STUDENT_TB");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                StudentBean s = new StudentBean();

                s.setStudentId(rs.getString(1));
                s.setStudentName(rs.getString(2));
                s.setRollNumber(rs.getString(3));
                s.setClassName(rs.getString(4));
                s.setAdmissionDate(rs.getDate(5));
                s.setAge(rs.getInt(6));
                s.setRemarks(rs.getString(7));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
   public String generateStudentID(String rollNumber, Date admissionDate) {
	   
	   Connection connection=DBUtil.getDBConnection();
		String query=" select  STUDENT_SEQ1.NEXTVAL from dual";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int sequence_no=rs.getInt(1);
			DateFormat f = new SimpleDateFormat("yyyyMMdd");  
			String temp = f.format(admissionDate);
			String stdId=temp+rollNumber.substring(0,2).toUpperCase()+sequence_no;
			return stdId;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
   }
}