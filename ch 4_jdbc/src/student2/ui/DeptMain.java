package student2.ui;

import java.util.List;
import java.util.Scanner;

import student2.dto.DeptDTO;
import student2.service.DeptService;

public class DeptMain {
    public static void main(String[] args) {
        boolean run = true;
        Scanner sc = new Scanner(System.in);

        DeptService deptService = new DeptService();
        ConsoleInfo info = new ConsoleInfo();

        while (run) {
            System.out.println(
                    "===============================================================================================");
            System.out.print("1. 학과 등록 | ");
            System.out.print("2. 학과 수정 | ");
            System.out.print("3. 학과 삭제 | ");
            System.out.print("4. 학과 조회 | ");
            System.out.print("5. 전체학과 조회 | ");
            System.out.println();
            System.out.print("6. 교수정보 입력 | ");
            System.out.print("7. 교수정보 수정 | ");
            System.out.print("8. 교수정보 삭제 | ");
            System.out.print("9. 교수정보 조회 | ");
            System.out.println("10. 프로그램 종료");
            System.out.println(
                    "===============================================================================================");
            System.out.print("선택 >> ");

            int menu = Integer.parseInt(sc.nextLine());
            switch (menu) {
                case 1:
                    // 추가할 학과번호, 학과명 입력받기
                    DeptDTO dto = info.setDept(sc);
                    boolean result = deptService.addDept(dto);
                    System.out.println(result ? "학과정보 추가 성공" : "학과정보 추가 실패");
                    break;
                case 2:
                    // 수정할 학과정보 입력받기
                    dto = info.setDept(sc);
                    // db 작업
                    result = deptService.updateDept(dto);
                    System.out.println(result ? "학과정보 수정 성공" : "학과정보 수정 실패");
                    break;
                case 3:
                    // 삭제할 학과번호 입력받기
                    String deptId = info.getDeptId(sc);
                    // db 작업
                    result = deptService.removeDept(deptId);
                    System.out.println(result ? "삭제 성공" : "삭제 실패");
                    break;
                case 4:
                    String deptname = info.getDeptName(sc);
                    dto = deptService.getDept(deptname);
                    info.print(dto);
                    break;
                case 5:
                    List<DeptDTO> list = deptService.getDepts();
                    info.printALl(list);
                    break;
                case 10:
                    run = false;
                    break;

                default:
                    break;
            }
        }
    }
}