package student2.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUitl {
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    // 데이터베이스 연결 메소드
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "javadb";
        String password = "12345";
        Connection con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(false);
        return con;
    }

    public static void commit(Connection con) {
        try {
            con.commit();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void rollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void close(Connection con) {
        try {

            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pstmt) {
        try {

            if (pstmt != null) {
                pstmt.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
