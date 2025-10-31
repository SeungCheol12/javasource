package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Delete {
    public static void main(String[] args) {
        // db 서버 연결

        // 1. 드라이버 로드
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "scott";
            String password = "tiger";
            // 2. DB 연결
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("연결되었습니다.");

            // 3. sql 구문
            String sql = "delete from emp where empno = 7499";

            PreparedStatement pstmt = con.prepareStatement(sql);
            int result = pstmt.executeUpdate();
            System.out.println(result > 0 ? "삭제 성공" : "삭제 실패");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
