package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProfessorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "javadb";
            String password = "12345";
            con = DriverManager.getConnection(url, user, password);

            boolean run = true;
            while (run) {
                System.out.println("==========================");
                System.out.println("1. 교수정보 입력");
                System.out.println("2. 교수정보 수정");
                System.out.println("3. 교수정보 삭제");
                System.out.println("4. 교수정보 조회");
                System.out.println("5. 프로그램 종료");
                System.out.println("==========================");
                System.out.print("선택 >>");

                int menu = Integer.parseInt(sc.nextLine());
                switch (menu) {
                    case 1:
                        ProfessorDTO professorDTO = insert();
                        String sql = "INSERT INTO PROFESSOR(PROF_ID, PROF_NAME, DEPT_ID ) VALUES (?, ?, ?)";
                        pstmt = con.prepareStatement(sql);
                        pstmt.setString(1, professorDTO.getProfId());
                        pstmt.setString(2, professorDTO.getProfName());
                        pstmt.setString(3, professorDTO.getDeptId());
                        int rows = pstmt.executeUpdate();

                        System.out.println(rows > 0 ? "입력성공" : "입력실패");
                        break;
                    case 2:
                        update();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        select();
                        break;
                    case 5:
                        run = false;
                        break;
                    default:
                        break;
                }
            }

        } catch (Exception e) {

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

    public static ProfessorDTO insert() {
        Scanner sc = new Scanner(System.in);

        System.out.print("아이디 입력 >>");
        String profID = sc.nextLine();
        System.out.print("이름 입력 >>");
        String name = sc.nextLine();
        System.out.print("학과 코드 입력 >>");
        String deptId = sc.nextLine();

        sc.close();

        return new ProfessorDTO(profID, name, deptId);
    }

    public static void update() {
    }

    public static void delete() {
    }

    public static void select() {
    }
}
