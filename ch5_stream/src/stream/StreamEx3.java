package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String[] args) {
        // 배열 => 스트림
        String[] strarr = { "사과", "바나나", "딸기", "포도", "메론" };
        // java.util.Arrays : 배열과 관련된 기능 제공
        // Arrays.toString(strarr) : 배열 값으로 출력
        // List<String> list = Arrays.asList(null) : 배열 => 리스트
        // Arrays.sort(strarr); : 정렬

        // 배열 => 스트림
        Stream<String> stream = Arrays.stream(strarr);
        // System.out.println(stream); => 값이 제대로 출력되지 않는다

        stream.forEach(s -> System.out.println(s));
        // stream.forEach(System.out::println); 오류 발생 => stream 은 일회용이라 연달아 출력할 수 없다

        System.out.println();

        // 배열의 형태로 리스트를 만들어서 add가 불가능하다
        List<String> list = Arrays.asList("사과", "바나나", "딸기", "포도", "메론");
        // list.add("수박"); => 오류 발생

        // 리스트 => 스트림
        Stream<String> stream2 = list.stream();
        stream2.forEach(System.out::println);

        // List.of(E ... elements) 인수의 개수는 자유롭게
        List<String> list2 = List.of("사과", "바나나", "딸기", "포도", "메론");
        // list2.add("수박"); 오류 발생 => aslist 처럼 추가가 불가능하다

        // 처음부터 스트림 생성
        Stream<String> stream3 = Stream.of("사과", "바나나", "딸기", "포도", "메론", "오이", "당근");

        // 숫자 범위로 스트림 생성
        IntStream.range(1, 10).forEach(System.out::println);
        IntStream.rangeClosed(1, 10).forEach(System.out::println);

        LongStream.range(1, 10);
        LongStream.rangeClosed(1, 10);
    }
}
