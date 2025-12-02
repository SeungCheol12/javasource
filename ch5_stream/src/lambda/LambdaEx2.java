package lambda;

public class LambdaEx2 {
    public static void main(String[] args) {
        Lambda4 lambda4 = () -> System.out.println("람다식");
        lambda4.run();

        System.out.println("-----------------------");
        excute(getRun());
    }

    // 함수형 인터페이스를 리턴타입으로 사용
    public static Lambda4 getRun() {
        Lambda4 lambda4 = () -> System.out.println("getRun");
        return lambda4;
    }

    // 함수형 인터페이스를 매개변수로 사용
    public static void excute(Lambda4 lambda4) {
        lambda4.run();
    }
}
