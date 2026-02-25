package basic;

public class UserEx {
    public static void main(String[] args) {

        String msg = """
                안녕하세요.
                """.stripIndent();
        var msg1 = new String();

        // User user = new User();
        User user2 = new User("홍길동", 23);

        // user.name = "성춘향"; => setter

        System.out.println(user2.name());
    }
}

// 화면단 <=====> backend
// ~~DTO => lombok => record