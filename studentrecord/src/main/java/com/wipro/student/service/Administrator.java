package com.wipro.student.service;

import java.util.Date;
import java.util.List;

import com.wipro.student.bean.StudentBean;
import com.wipro.student.dao.StudentDAO;
import com.wipro.student.util.InvalidInputException;

public class Administrator {

    StudentDAO dao = new StudentDAO();

    public String addRecord(StudentBean s) {

        try {

            if (s == null ||
                s.getStudentName() == null ||
                s.getRollNumber() == null ||
                s.getAdmissionDate() == null)
                throw new InvalidInputException();

            if (s.getStudentName().length() < 2)
                return "INVALID STUDENT NAME";

            if (s.getRollNumber().length() < 2)
                return "INVALID ROLL NUMBER";

            if (s.getClassName().length() < 1)
                return "INVALID CLASS";

            if (s.getAge() <= 0)
                return "INVALID AGE";

            if (dao.recordExists(s.getRollNumber(),
                                 s.getAdmissionDate()))
                return "ALREADY EXISTS";

            String id =
                dao.generateStudentID(
                    s.getRollNumber(),
                    s.getAdmissionDate());

            s.setStudentId(id);

            return dao.createRecord(s);

        } catch (InvalidInputException e) {
            return "INVALID INPUT";
        }
    }

    public StudentBean viewRecord(String roll, Date date) {
        return dao.fetchRecord(roll, date);
    }

    public List<StudentBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}