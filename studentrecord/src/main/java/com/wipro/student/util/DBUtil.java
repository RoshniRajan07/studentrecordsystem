package com.wipro.student.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getDBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "roshni"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
