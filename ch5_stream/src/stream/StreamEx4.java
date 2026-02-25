package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx4 {
    public static void main(String[] args) {

        Stream<File> stream = Stream.of(new File("file1.txt"), new File("file2.txt"), new File("file3.txt"),
                new File("file4.txt"));

        // map() : 스트림 요소에 저장된 값 중에서 원하는 필드만 추출
        // stream.map(Function<File, String> mapper)
        // Stream<String> names = stream.map((f) -> f.getName());
        Stream<String> names = stream.map(File::getName);
        names.forEach(System.out::println);

        List<File> list = List.of(new File("file1.txt"), new File("file2.txt"), new File("file3.txt"),
                new File("file4.txt"));
        // 파일명만 추출해서 하나의 리스트로 반환
        List<String> nameList = new ArrayList<>();
        for (File f : list) {
            nameList.add(f.getName());
        }
        System.out.println(nameList);
        // list에서 대문자로 변경 후 출력
        List<String> list2 = List.of("abc", "def", "apple", "melon", "text");
        for (String string : list2) {
            System.out.println(string.toUpperCase());
        }
        // stream 으로 출력
        Stream<String> stream2 = Stream.of("abc", "def", "apple", "melon", "text");
        // stream2.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        stream2.map(String::toUpperCase).forEach(System.out::println);

        // filter : 조건에 안 맞는 요소 제외
        List<String> list3 = List.of("바둑", "바나나", "포도", "딸기", "바질", "강아지");
        // "바" 로 시작하는 요소 출력
        for (String string : list3) {
            if (string.startsWith("바")) {
                System.out.println(string);
            }
        }

        System.out.println();

        Stream<String> stream3 = list3.stream();
        // stream3.filter(Predicate<? super String> predicate)
        stream3.filter((s) -> s.startsWith("바")).forEach(s -> System.out.println(s));

        // 이름이 "이" 로 시작하는 학생 출력
        List<Student> list4 = new ArrayList<>();
        list4.add(new Student("홍길동", 98));
        list4.add(new Student("김길동", 95));
        list4.add(new Student("박길동", 88));
        list4.add(new Student("이길동", 78));

        for (Student student : list4) {
            if (student.getName().startsWith("바")) {
                System.out.println(student);
            }
        }
        Stream<Student> stream4 = Stream.of(new Student("홍길동", 98), new Student("김길동", 95), new Student("박길동", 88),
                new Student("이길동", 78));
        stream4.filter(s -> s.getName().startsWith("이")).forEach(System.out::println);

        // 중복제거 distinct
        Stream<String> stream5 = Stream.of("바둑", "바나나", "포도", "딸기", "바질", "강아지", "바둑");
        stream5.distinct().forEach(System.out::println);

        // txt, bak, java
        File file = new File("Arr.java");
        System.out.println(file.getName());
        // 확장자 추출
        String filename = file.getName();
        System.out.println(filename.substring(filename.lastIndexOf(".") + 1));

        Stream<File> stream6 = Stream.of(new File("file1.txt"), new File("file2.txt"), new File("Ex1"),
                new File("Ex2.bak"), new File("Test.java"));
        stream6.map(File::getName) // 이름만 추출
                .filter(f -> f.lastIndexOf(".") > -1) // 확장자가 있는 이름만 추출
                .map(f -> f.substring(f.lastIndexOf(".") + 1)) // 확장자만 추출
                .distinct() // 중복 제거
                .forEach(System.out::println); // 출력

        // peel() : 중간 연산 확인

        // skip(), limit()
        Stream<String> stream7 = Stream.of("바둑", "바나나", "포도", "딸기", "바질", "강아지", "바둑");
        stream7.skip(2).limit(3).forEach(System.out::println);

        // collect()
        Stream<Student> stream8 = Stream.of(new Student("홍길동", 98), new Student("김길동", 95), new Student("박길동", 88),
                new Student("이길동", 78));
        // 점수만 모아서 새로운 리스트로 반환
        List<Integer> list6 = stream8.map(s -> s.getJumsu()).collect(Collectors.toList());
        System.out.println(list6);

        long count = IntStream.rangeClosed(1, 10).filter(i -> i % 2 == 0).count();
        System.out.println("2의 배수 개수" + count);

        OptionalDouble avg = IntStream.rangeClosed(1, 10).filter(i -> i % 2 == 0).average();
        System.out.println("2의 배수 평균" + avg);

        int sum = IntStream.rangeClosed(1, 10).filter(i -> i % 2 == 0).sum();
        System.out.println("2의 배수 합" + sum);

        OptionalInt max = IntStream.rangeClosed(1, 10).filter(i -> i % 2 == 0).max();
        System.out.println("2의 배수 최대값" + max);

        OptionalInt min = IntStream.rangeClosed(1, 10).filter(i -> i % 2 == 0).min();
        System.out.println("2의 배수 최소값" + min);
    }
}
