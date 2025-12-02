package lambda;

public class LambdaEx1 {
    public static void main(String[] args) {
        // Lambda lambda = new Lambda() {

        // @Override
        // public void method() {

        // throw new UnsupportedOperationException("Unimplemented method 'method'");
        // }

        // };
        // lambda.method();
        // 추상메소드를 하나만 가지고 있는 함수형 인터페이스만 가능하다
        Lambda lambda = () -> System.out.println("함수형 인터페이스");
        lambda.method();
        lambda = () -> {
            int i = 10;
            System.out.println("함수형 인터페이스" + i);
        };
        lambda.method();

        Lambda2 lambda2 = (x) -> System.out.println(x);
        lambda2.method(15);

        lambda2 = (x) -> {
            int result = x + x;
            System.out.println(result);
        };
        lambda2.method(30);

        Lambda3 lambda3 = (a, b) -> a > b ? a : b;
        System.out.println("큰 수 (5, 7) " + lambda3.max(5, 7));
    }
}
