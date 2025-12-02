package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("사과");
        list.add("포도");
        list.add("수박");
        list.add("배");

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println();

        // 정렬(원본) 후 출력
        // list.sort(Comparator.naturalOrder());
        // System.out.println(list);

        System.out.println();
        String[] strarr = { "파인애플", "배", "바나나", "사과" };
        // 배열 => list 변경
        // List<String> list2 = Arrays.asList(strarr);

        // 정렬(원본) 후 출력
        // Arrays.sort(strarr);
        // System.out.println(Arrays.toString(strarr));

        System.out.println();
        // 리스트를 Stream 으로 변경
        Stream<String> stream1 = list.stream();

        // 배열을 Stream 으로 변경

        Stream<String> stream2 = Arrays.stream(strarr);

        // 원본을 변경하지 않고 정렬
        // Consumer<? super String> action
        // Consumer
        System.out.println();
        stream1.sorted().forEach((x) -> System.out.println(x));

        System.out.println();
        stream2.sorted().forEach((x) -> System.out.println(x));

        // 원본이 변경되지 않았다
        System.out.println();
        System.out.println(list);
        System.out.println(Arrays.toString(strarr));
    }
}
