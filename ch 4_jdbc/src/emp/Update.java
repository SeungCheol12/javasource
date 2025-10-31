package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Update {
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

            // 수정할 학생아이디 입력 받기
            System.out.print("아이디 입력 >>");
            String studentID = sc.nextLine();
            System.out.print("키 입력 >>");
            double height = Double.parseDouble(sc.nextLine());

            String sql = "update student set height = ? where student_Id =?";
            pstmt = con.prepareStatement(sql);
            pstmt.setDouble(1, height);
            pstmt.setString(2, studentID);
            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "수정성공" : "수정실패");

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                con.close();
                sc.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}
