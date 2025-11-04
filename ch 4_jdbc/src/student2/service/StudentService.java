package student2.service;

import static student2.repository.JDBCUitl.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import student2.dto.StudentDTO;
import student2.repository.StudentDAO;

public class StudentService {

    public boolean addStudent(StudentDTO studentDTO) {
        Connection con = null;
        boolean isAdd = false;
        try {
            // db 작업
            con = getConnection();
            StudentDAO studentDAO = new StudentDAO(con);
            int result = studentDAO.insert(studentDTO);

            if (result > 0) {
                commit(con);
                isAdd = true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
            rollback(con);
        } finally {

            close(con);
        }
        return isAdd;
    }

    public boolean updateStudent(StudentDTO studentDTO) {
        Connection con = null;
        boolean isUpdate = false;
        try {
            // db 작업
            con = getConnection();
            StudentDAO studentDAO = new StudentDAO(con);
            int result = studentDAO.update(studentDTO);

            if (result > 0) {
                commit(con);
                isUpdate = true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
            rollback(con);
        } finally {

            close(con);
        }
        return isUpdate;
    }

    public boolean removeStudent(int studentId) {
        Connection con = null;
        boolean isDelete = false;
        try {
            // db 작업
            con = getConnection();
            StudentDAO studentDAO = new StudentDAO(con);
            int result = studentDAO.delete(studentId);

            if (result > 0) {
                commit(con);
                isDelete = true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
            rollback(con);
        } finally {

            close(con);
        }
        return isDelete;
    }

    public StudentDTO getStudent(int studentId) {
        Connection con = null;

        try {
            // db 작업
            con = getConnection();
            StudentDAO studentDAO = new StudentDAO(con);
            StudentDTO studentDTO = studentDAO.getrow(studentId);
            return studentDTO;

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            close(con);
        }
        return null;
    }

    public List<StudentDTO> getStudents() {
        Connection con = null;

        try {
            // db 작업
            con = getConnection();
            StudentDAO studentDAO = new StudentDAO(con);
            List<StudentDTO> list = studentDAO.getrows();
            return list;

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            close(con);
        }
        return null;
    }
}
