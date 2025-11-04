package student2.ui;

import java.util.List;
import java.util.Scanner;

import student2.dto.DeptDTO;
import student2.dto.ProfessorDTO;
import student2.dto.StudentDTO;
import student2.service.DeptService;
import student2.service.ProfessorService;
import student2.service.StudentService;

public class DeptMain {
    public static void main(String[] args) {
        boolean run = true;
        Scanner sc = new Scanner(System.in);

        DeptService deptService = new DeptService();
        ConsoleInfo info = new ConsoleInfo();
        ProfessorService professorService = new ProfessorService();
        StudentService studentService = new StudentService();
        while (run) {
            System.out.println(
                    "===============================================================================================");
            System.out.print("1. 학과 등록 | ");
            System.out.print("2. 학과 수정 | ");
            System.out.print("3. 학과 삭제 | ");
            System.out.print("4. 학과 조회 | ");
            System.out.print("5. 전체학과 조회 | ");
            System.out.println();
            System.out.println();
            System.out.print("6. 교수정보 입력 | ");
            System.out.print("7. 교수정보 수정 | ");
            System.out.print("8. 교수정보 삭제 | ");
            System.out.print("9. 교수정보 조회 | ");
            System.out.println();
            System.out.println();
            System.out.print("10. 학생정보 입력 | ");
            System.out.print("11. 학생정보 수정 | ");
            System.out.print("12. 학생정보 삭제 | ");
            System.out.print("13. 학생정보 조회(학과별) | ");
            System.out.print("14. 학생정보 조회(개인별) | ");
            System.out.println("15. 프로그램 종료");
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
                case 6:
                    // 새 교수 정보 입력받기
                    ProfessorDTO professorDTO = info.insertProfessor(sc);
                    // 입력정보 서비스로 넘겨준 후 결과 받기
                    result = professorService.insertProfessor(professorDTO);
                    System.out.println(result ? "교수 정보 추가 성공" : "교수 정보 추가 실패");
                    break;
                case 7:
                    // 수정할 교수 정보 입력
                    professorDTO = info.updateProfessor(sc);
                    // 수정 정보 서비스로 넘겨준 후 결과 받기
                    result = professorService.updateProfessor(professorDTO);
                    System.out.println(result ? "교수 정보 수정 성공" : "교수 정보 수정 실패");
                    break;
                case 8:
                    // 삭제할 교수 정보 입력
                    String profId = info.deleteProfessor(sc);
                    // 삭제 정보 서비스로 넘겨준 후 결과 받기
                    result = professorService.deleteProfessor(profId);
                    System.out.println(result ? "교수 정보 삭제 성공" : "교수 정보 삭제 실패");
                    break;
                case 9:
                    // 조회할 교수 정보 입력
                    profId = info.selectProfessor(sc);
                    // 조회 정보 서비스로 넘겨준 후 결과 받기
                    professorDTO = professorService.getProfessor(profId);
                    info.printProfessor(professorDTO);
                    break;
                case 10:
                    // 학생입력
                    StudentDTO studentDTO = info.insertStudent(sc);
                    result = studentService.addStudent(studentDTO);
                    System.out.println(result ? "학생 정보 추가 성공" : "학생 정보 추가 실패");
                    break;
                case 11:
                    // 수정
                    studentDTO = info.updateStudent(sc);
                    result = studentService.updateStudent(studentDTO);
                    System.out.println(result ? "학생 정보 수정 성공" : "학생 정보 수정 실패");
                    break;
                case 12:
                    // 삭제
                    int studentId = info.deleteStudent(sc);
                    result = studentService.removeStudent(studentId);
                    System.out.println(result ? "학생 정보 삭제 성공" : "학생 정보 삭제 실패");
                    break;
                case 13:
                    // 학과별 조회
                    deptId = info.getDeptStudent(sc);
                    List<StudentDTO> slist = studentService.getStudents();
                    info.printallstudent(slist);
                    break;
                case 14:
                    // 개인별 조회
                    int studentid = info.getStudentId(sc);
                    studentDTO = studentService.getStudent(studentid);
                    info.printstudent(studentDTO);
                    break;
                case 15:
                    run = false;
                    break;

                default:
                    break;
            }
        }
    }
}