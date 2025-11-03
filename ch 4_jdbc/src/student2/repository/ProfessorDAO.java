package student2.repository;

import static student2.repository.JDBCUitl.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student2.dto.ProfessorDTO;

public class ProfessorDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // static {
    // try {
    // Class.forName("oracle.jdbc.OracleDriver");
    // } catch (ClassNotFoundException e) {

    // e.printStackTrace();
    // }
    // }

    // // 데이터베이스 연결 메소드
    // public Connection getConnection() throws SQLException {
    // String url = "jdbc:oracle:thin:@localhost:1521:xe";
    // String user = "javadb";
    // String password = "12345";
    // con = DriverManager.getConnection(url, user, password);
    // return con;
    // }

    public ProfessorDAO(Connection con) {
        this.con = con;
    }

    public int insert() {
        int result = 0;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(pstmt);
        }
        return result;
    }

    public int update() {
        int result = 0;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int delete() {
        int result = 0;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }

    public ProfessorDTO getRow() {
        ProfessorDTO dto = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(rs);
        }
        return dto;
    }

}
