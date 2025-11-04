package student2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import student2.dto.DeptDTO;
import student2.dto.StudentDTO;
import static student2.repository.JDBCUitl.*;

public class StudentDAO {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public StudentDAO(Connection con) {
        this.con = con;
    }

    // insert
    public int insert(StudentDTO studentDTO) {
        int result = 0;
        try {

            String sql = "INSERT INTO STUDENT(student_id, student_name, height, dept_id) VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);

            // ? 해결
            pstmt.setInt(1, studentDTO.getStudentId());
            pstmt.setString(2, studentDTO.getStudentName());
            pstmt.setDouble(3, studentDTO.getStudentHeight());
            pstmt.setString(4, studentDTO.getDeptId());
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // JDBCUitl.close(pstmt); 위에 import 선언해서 클래스 명을 떼어낸다
            close(pstmt);

        }
        return result;
    }

    // delete(studentId)
    public int delete(int studentId) {
        int result = 0;
        try {

            String sql = "delete STUDENT where student_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, studentId);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }

    // update : height 수정
    public int update(StudentDTO studentDTO) {
        int result = 0;
        try {

            String sql = "update STUDENT set height = ? where student_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, studentDTO.getStudentHeight());
            pstmt.setInt(2, studentDTO.getStudentId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(pstmt);
        }
        return result;
    }

    // 학생 조회(1명 = id로)
    public StudentDTO getrow(int studentId) {
        StudentDTO studentDTO = null;
        try {

            String sql = "select * from STUDENT where student_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, studentId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                Double studentHeight = rs.getDouble("height");
                String deptId = rs.getString("dept_id");

                studentDTO = new StudentDTO(studentId, studentName, studentHeight, deptId);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return studentDTO;
    }

    // 학생 전체 조회(dept_id)
    public List<StudentDTO> getrows() {
        List<StudentDTO> list = new ArrayList<>();
        try {

            String sql = "select * from student";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                int studentId = rs.getInt("student_id");
                String studentname = rs.getString("student_name");
                Double studentHeight = rs.getDouble("height");
                String deptId = rs.getString("dept_id");

                // DeptDTO deptDTO = new DeptDTO(deptId, deptName);
                // list.add(deptDTO);
                list.add(new StudentDTO(studentId, studentname, studentHeight, deptId));
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
