package stream;

public class Student {
    private String name;
    private Integer jumsu;

    public Student(String name, Integer jumsu) {
        this.name = name;
        this.jumsu = jumsu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJumsu() {
        return jumsu;
    }

    public void setJumsu(Integer jumsu) {
        this.jumsu = jumsu;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", jumsu=" + jumsu + "]";
    }

}
