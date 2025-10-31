package emp;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
