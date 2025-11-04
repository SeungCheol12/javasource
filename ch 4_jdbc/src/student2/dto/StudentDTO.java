package student2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    // 테이블 모양
    private int studentId;
    private String studentName;
    private double studentHeight;
    private String deptId;

}
