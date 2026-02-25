import java.util.ArrayList;
import java.util.List;

public class Team {

    private Long id;

    private String name;

    private List<TeamMember> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(List<TeamMember> members) {
        this.members = members;
    }

    public List<TeamMember> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + "]";
    }

}
