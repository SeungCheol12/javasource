package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "javadb";
            String password = "12345";
            con = DriverManager.getConnection(url, user, password);

            String sql = "select * from student";

            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("student_id");
                String name = rs.getString("name");
                int height = rs.getInt("height");
                String deptId = rs.getString("dept_id");
                System.out.printf("%s\t%s\t%d\t%s\n", id, name, height, deptId);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                rs.close();
                psmt.close();
                con.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

    }
}
