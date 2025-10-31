package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Delete2 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "javadb";
            String password = "12345";

            con = DriverManager.getConnection(url, user, password);

            // 삭제할 학생아이디 입력 받기
            System.out.print("아이디 입력 >>");
            String studentID = sc.nextLine();
            // 부모 삭제
            String sql = "delete from enrollment where student_Id =?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, studentID);
            int rows = pstmt.executeUpdate();

            sql = "delete from student where student_Id =?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, studentID);
            rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "삭제성공" : "삭제실패");

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                con.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}
