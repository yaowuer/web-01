package com.nf152.web01.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
    public static void close(Connection conn) {
        close(conn, null, null);
    }
    public static void close(Connection conn, Statement stmt, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception ignored) {}
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception ignored) {}
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ignored) {}
        }
    }
    public static Connection getConnection () throws Exception {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:e:/data/student.sqlite3");
    }
}
