package student2.repository;
// DAO (Data Access Object) : 데이터베이스 관련 작업

import static student2.repository.JDBCUitl.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student2.dto.DeptDTO;

public class DeptDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public DeptDAO(Connection con) {
        this.con = con;
    }

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

    // int rows = pstmt.executeUpdate(); 로 반환되기 때문에 int로 한다
    public int insert(DeptDTO dto) {
        int result = 0;
        try {

            String sql = "INSERT INTO DEPARTMENT(dept_id, dept_name) VALUES (?, ?)";
            pstmt = con.prepareStatement(sql);

            // ? 해결
            pstmt.setString(1, dto.getDeptId());
            pstmt.setString(2, dto.getDeptName());
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // JDBCUitl.close(pstmt); 위에 import 선언해서 클래스 명을 떼어낸다
            close(pstmt);

        }
        return result;
    }

    public int delete(String deptId) {
        int result = 0;
        try {

            String sql = "delete DEPARTMENT where dept_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, deptId);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int update(DeptDTO dto) {
        int result = 0;
        try {

            String sql = "update DEPARTMENT set dept_name = ? where dept_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getDeptName());
            pstmt.setString(2, dto.getDeptId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(pstmt);
        }
        return result;
    }

    // 조회 결과가 하나만 나오는 경우
    // 학과 이름을 입력받고 출력
    public DeptDTO getrow(String deptName) {
        DeptDTO deptDTO = null;
        try {

            String sql = "select * from DEPARTMENT where dept_name = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, deptName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String deptId = rs.getString("dept_id");
                deptName = rs.getString("dept_name");

                deptDTO = new DeptDTO(deptId, deptName);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return deptDTO;
    }

    // 조회 결과가 여러개 나오는 경우
    // 전체학과 조회
    public List<DeptDTO> getrows() {
        List<DeptDTO> list = new ArrayList<>();
        try {

            String sql = "select * from DEPARTMENT";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String deptId = rs.getString("dept_id");
                String deptName = rs.getString("dept_name");

                // DeptDTO deptDTO = new DeptDTO(deptId, deptName);
                // list.add(deptDTO);
                list.add(new DeptDTO(deptId, deptName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);

        }
        return list;
    }
}
