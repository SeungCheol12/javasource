public class TVEX {
    public static void main(String[] args) {
        // 객체 생성
        LGTV tv = new LGTV();
        tv.setSepeaker(new AppleSepeaker());
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
    }
}
