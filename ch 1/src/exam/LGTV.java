pakcage exam

public class LGTV implements TV {
    private Sepeaker sepeaker;

    // setter, 생성자
    public LGTV(Sepeaker sepeaker) {
        this.sepeaker = sepeaker;
    }

    public LGTV() {

    }

    public void setSepeaker(Sepeaker sepeaker) {
        this.sepeaker = sepeaker;
    }

    @Override
    public void powerOn() {
        System.out.println("LGTV Power On");
    }

    @Override
    public void powerOff() {
        System.out.println("LGTV Power Off");
    }

    @Override
    public void volumeUp() {
        // System.out.println("LGTV Volume Up");
        sepeaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        System.out.println("LGV Volume Down");
    }

}
