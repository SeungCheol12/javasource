package student2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//  @Data = @toString, @Setter, @Getter, @RequiredArgsConstructor, @EqualsAndHashCode

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptDTO {
    private String deptId;
    private String deptName;

}
