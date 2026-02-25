package stream;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalEx1 {
    public static void main(String[] args) {
        Optional<String> optVal = Optional.of("abc");

        String str1 = optVal.get(); // 값 가져오기(=> 값이 없다면 NoSuchElementException 발생)
        String str2 = optVal.orElse("");
        String str3 = optVal.orElseGet(String::new);
        String str4 = optVal.orElseThrow();
    }
}
