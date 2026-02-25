public class AppleSepeaker implements Sepeaker {

    public AppleSepeaker() {
        System.out.println("AppleSepeaker 객체 생성");
    }

    @Override
    public void volumeUp() {
        System.out.println("AppleSepeaker Volume Up");
    }

    @Override
    public void volumeDown() {
        System.out.println("AppleSepeaker Volume Down");
    }

}
