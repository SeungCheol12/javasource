package student2.service;

import java.sql.Connection;
import java.sql.SQLException;

import student2.dto.ProfessorDTO;
import static student2.repository.JDBCUitl.*;
import student2.repository.ProfessorDAO;

// controller <==> service <==> DAO
public class ProfessorService {
    Connection con = null;

    public boolean insertProfessor(ProfessorDTO dto) {
        try {
            con = getConnection();
            ProfessorDAO dao = new ProfessorDAO(con);

            int rows = dao.insert(dto);
            if (rows > 0) {
                commit(con);
                return true;
            }
        } catch (SQLException e) {

            e.printStackTrace();
            rollback(con);
        } finally {
            close(con);
        }
        return false;
    }

    public boolean updateProfessor(ProfessorDTO dto) {
        try {
            con = getConnection();
            ProfessorDAO dao = new ProfessorDAO(con);

            int rows = dao.update(dto);
            if (rows > 0) {
                commit(con);
                return true;
            }
        } catch (SQLException e) {

            e.printStackTrace();
            rollback(con);
        } finally {
            close(con);
        }
        return false;
    }

    public boolean deleteProfessor(String profid) {
        try {
            con = getConnection();
            ProfessorDAO dao = new ProfessorDAO(con);

            int rows = dao.delete(profid);
            if (rows > 0) {
                commit(con);
                return true;
            }
        } catch (SQLException e) {

            e.printStackTrace();
            rollback(con);
        } finally {
            close(con);
        }
        return false;
    }

    public ProfessorDTO getProfessor(String profid) {
        try {
            con = getConnection();
            ProfessorDAO dao = new ProfessorDAO(con);

            ProfessorDTO dto = dao.getRow(profid);
            return dto;
        } catch (SQLException e) {

            e.printStackTrace();
            rollback(con);
        } finally {
            close(con);
        }
        return null;
    }
}
