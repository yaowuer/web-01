package com.nf152.web01.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    /**
     * usage:
     *
     *   DBUtil.execute("insert into xxx (name, age) values (?, ?)", "tom", 12);
     *   DBUtil.execute("delete from xxx where id = ?", 22);
     */
    public static int execute(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = getPrepareStatement(conn, sql, params);
            return ps.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("执行 SQL 出错: " + ex.getMessage());
        } finally {
            close(conn, ps, null);
        }
    }

    /**
     * usage:
     *
     *   List<Student> students =
     *     DBUtil.queryForList(Student.class, "select * from student where score > ?", 33);
     */
    public static <T> List<T> queryList(Class<T> clazz, String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            List<T> rets = new ArrayList<>();

            conn = getConnection();
            ps = getPrepareStatement(conn, sql, params);

            rs = ps.executeQuery();

            while (rs.next()) {
                T instance = clazz.getDeclaredConstructor().newInstance();
                ResultSetMetaData metaData = rs.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String colmnName = metaData.getColumnName(i);  // 字段名
                    String fieldName = getCalmName(colmnName);
                    String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1); // setXxx 方法名
                    Field field = clazz.getDeclaredField(fieldName);
                    Method method = clazz.getDeclaredMethod(methodName, field.getType());
                    method.invoke(instance, field.getType().cast(rs.getObject(i)));
                }
                rets.add(instance);
            }

            return rets.size() > 0 ? rets : null;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("查询出错: " + ex.getMessage());
        } finally {
            close(conn, ps, rs);
        }
    }

    public static <T> T queryOne (Class<T> clazz, String sql, Object... params) {
        List<T> ts = queryList(clazz, sql, params);
        return ts == null ? null : ts.get(0);
    }

    private static PreparedStatement getPrepareStatement (Connection conn, String sql, Object... params) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        System.out.printf("-- %s", sql);
        for (int i = 1; i <= params.length; i++) {
            ps.setObject(i, params[i - 1]);
            System.out.printf(",  %s", params[i - 1]);
        }
        System.out.println();
        return ps;
    }

    private static String getCalmName(String name) {
        if (name != null && !name.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0, len = name.length(); i < len; i++) {
                if (name.charAt(i) == '_') {
                    while (name.charAt(i + 1) == '_') {
                        i++;
                    }
                    stringBuilder.append(("" + name.charAt(++i)).toUpperCase());
                } else {
                    stringBuilder.append(name.charAt(i));
                }
            }
            return stringBuilder.toString();
        }
        return name;
    }

    //////////////////////////

    public static Connection getConnection() throws Exception {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:e:/data/student.sqlite3");
    }

    public static void close(Connection conn, Statement stmt, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception ignored) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception ignored) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ignored) {
            }
        }
    }

}
