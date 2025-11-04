package student2.ui;

import java.util.List;
import java.util.Scanner;

import student2.dto.DeptDTO;
import student2.dto.ProfessorDTO;
import student2.dto.StudentDTO;

public class ConsoleInfo {
    // deptId 입력받아서 리턴
    public String getDeptId(Scanner sc) {
        System.out.println("\n------- 학과 정보 입력 -------");
        System.out.print("학과 번호 >> ");
        String deptId = sc.nextLine();

        return deptId;
    }

    // deptId, deptName 입력받아서 리턴
    public DeptDTO setDept(Scanner sc) {
        // 첫번째 방식이 더 보편적으로 쓰인다
        System.out.println("\n------- 학과 정보 입력 -------");
        System.out.print("학과 번호 >> ");
        String deptId = sc.nextLine();
        System.out.print("학과명 >> ");
        String deptName = sc.nextLine();

        return new DeptDTO(deptId, deptName);

        // DeptDTO dto = new DeptDTO();
        // System.out.println("학과 번호 >> ");
        // dto.setDeptId(sc.nextLine());
        // System.out.println("학과명 >> ");
        // dto.setDeptName(sc.nextLine());

        // return dto;
    }

    // deptName 입력 받아서 리턴
    public String getDeptName(Scanner sc) {
        System.out.print("학과명 >> ");
        String deptName = sc.nextLine();
        return deptName;
    }

    // 특정 학과 조회
    public void print(DeptDTO deptDTO) {
        System.out.println("\n------- 학과 정보 -------");
        System.out.println("학과번호\t학과명");
        System.out.println("---------------------------");

        System.out.print(deptDTO.getDeptId() + '\t');
        System.out.println(deptDTO.getDeptName());

    }

    // 전체 학과 조회
    public void printALl(List<DeptDTO> list) {
        System.out.println("\n------- 전체학과 정보 -------");
        System.out.println("학과번호\t학과명");
        System.out.println("---------------------------");
        for (DeptDTO deptDTO : list) {
            System.out.print(deptDTO.getDeptId() + '\t');
            System.out.println(deptDTO.getDeptName());
        }
    }

    public ProfessorDTO insertProfessor(Scanner sc) {

        System.out.print("교수 번호 입력 >>");
        String profId = sc.nextLine();
        System.out.print("이름 입력 >>");
        String name = sc.nextLine();
        System.out.print("학과 번호 입력 >>");
        String deptId = sc.nextLine();

        return new ProfessorDTO(profId, name, deptId);
    }

    public ProfessorDTO updateProfessor(Scanner sc) {
        // 수정할 교수 아이디 받기

        System.out.println("======== 수정할 교수 정보 ========");
        System.out.print("교수 번호 >> ");
        String profId = sc.nextLine();
        System.out.print("변경할 학과 번호 >> ");
        String deptId = sc.nextLine();

        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setDeptId(deptId);
        professorDTO.setProfId(profId);

        return professorDTO;
    }

    public String deleteProfessor(Scanner sc) {
        // 삭제할 교수 아이디

        System.out.println("======== 삭제할 교수 정보 ========");
        System.out.print("교수 번호 >> ");
        String profId = sc.nextLine();

        return profId;
    }

    public String selectProfessor(Scanner sc) {
        // 특정 교수 조회

        System.out.println("======== 교수 조회 ========");
        System.out.print("교수 번호 >> ");
        String profId = sc.nextLine();

        return profId;

    }

    public void printProfessor(ProfessorDTO dto) {
        System.out.println("교수 번호 : " + dto.getProfId());
        System.out.println("교수명 : " + dto.getProfName());
        System.out.println("학과 번호 : " + dto.getDeptId());
    }

    // 새 학생 정보 입력받기
    public StudentDTO insertStudent(Scanner sc) {
        System.out.print("학생 번호 입력 >> ");
        int studentid = Integer.parseInt(sc.nextLine());
        System.out.print("학생 이름 입력 >> ");
        String studentName = sc.nextLine();
        System.out.print("키 입력 >>");
        Double studentHeight = Double.parseDouble(sc.nextLine());
        System.out.print("학과 번호 입력 >>");
        String deptId = sc.nextLine();

        return new StudentDTO(studentid, studentName, studentHeight, deptId);
    }

    public int deleteStudent(Scanner sc) {
        System.out.println("======== 삭제할 학생 정보 ========");
        System.out.print("학생 번호 >> ");
        int studentId = Integer.parseInt(sc.nextLine());

        return studentId;
    }

    public StudentDTO updateStudent(Scanner sc) {
        System.out.println("======== 수정할 학생 정보 ========");
        System.out.print("학생 번호 >> ");
        int studentId = Integer.parseInt(sc.nextLine());
        System.out.print("키 >> ");
        Double studentHeight = Double.parseDouble(sc.nextLine());

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(studentId);
        studentDTO.setStudentHeight(studentHeight);

        return studentDTO;
    }

    public String getDeptStudent(Scanner sc) {
        System.out.println("======== 학생 조회 ========");
        System.out.print("학과 번호 >> ");
        String deptId = sc.nextLine();

        return deptId;
    }

    public int getStudentId(Scanner sc) {
        System.out.print("학생 번호 >> ");
        int studentId = Integer.parseInt(sc.nextLine());

        return studentId;
    }

    public void printstudent(StudentDTO dto) {
        System.out.printf("%d\t%s\t%.2f\t%s", dto.getStudentId(), dto.getStudentName(),
                dto.getStudentHeight(), dto.getDeptId());
    }

    public void printallstudent(List<StudentDTO> list) {
        for (StudentDTO dto : list) {
            System.out.printf("%d\t%s\t%.2f\t%s\n", dto.getStudentId(), dto.getStudentName(),
                    dto.getStudentHeight(), dto.getDeptId());
        }
    }
}
