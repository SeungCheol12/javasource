package lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx3 {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100) + 1;
        System.out.println(supplier.get());

        Consumer<Integer> consumer = (t) -> System.out.println(t);
        consumer.accept(10);

        Predicate<Integer> predicate = (x) -> x % 2 == 0;
        System.out.println(predicate.test(14));

        Function<Integer, Integer> function = (x) -> x * x;
        System.out.println(function.apply(10));

        Function<String, Integer> function2 = (x) -> Integer.parseInt(x);
        System.out.println(function2.apply("15"));

        // 문자열의 길이가 0 이라면 '빈 문자열입니다' 출력
        // System.out.println(str.length() == 0 ? "빈 문자열입니다" : str);

        String str = "";
        Predicate<String> predicate2 = (s) -> s.length() == 0;
        System.out.println(predicate2.test("") ? "빈 문자열입니다" : str);

        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x + y);
        biConsumer.accept(5, 6);

        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;
        System.out.println(biFunction.apply(1, 2));

        BiFunction<String, String, Boolean> biFunction2 = (s1, s2) -> s1.equals(s2); // return s1.equals(s2)
        System.out.println(biFunction2.apply("test", "test1"));

        biFunction2 = String::equals;
    }
}
