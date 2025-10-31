package student;
// ~~DTO(Data Transfer Object) = ~~ VO(Value Object)

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProfessorDTO {
    private String profId;
    private String profName;
    private String deptId;

    // // 생성자
    // public ProfessorDTO() {
    // }

    // public ProfessorDTO(String profId, String profName, String deptId) {
    // this.profId = profId;
    // this.profName = profName;
    // this.deptId = deptId;
    // }

    // // 게터 세터 tostring
    // public String getProfId() {
    // return profId;
    // }

    // public void setProfId(String profId) {
    // this.profId = profId;
    // }

    // public String getProfName() {
    // return profName;
    // }

    // public void setProfName(String profName) {
    // this.profName = profName;
    // }

    // public String getDeptId() {
    // return deptId;
    // }

    // public void setDeptId(String deptId) {
    // this.deptId = deptId;
    // }

    // @Override
    // public String toString() {
    // return "ProfessorDTO [profId=" + profId + ", profName=" + profName + ",
    // deptId=" + deptId + "]";
    // }

}
