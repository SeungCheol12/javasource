package stream;

import java.util.ArrayList;
import java.util.List;

public class StreamEx2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("홍길동", 98));
        list.add(new Student("김길동", 95));
        list.add(new Student("박길동", 88));
        list.add(new Student("이길동", 78));
        // foreach

        // list.forEach(null);

        // 원본을 수정하지 않는다
        list.stream().forEach((s) -> System.out.println(s.getName() + ":" + s.getJumsu()));
        list.stream().forEach(System.out::println);
    }

}
