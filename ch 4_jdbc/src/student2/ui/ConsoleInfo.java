package student2.ui;

import java.util.List;
import java.util.Scanner;

import student2.dto.DeptDTO;

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
}
