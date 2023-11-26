package HanoiG1;

public class Disc {
    private int radio;

    public Disc() {
    }

    public Disc(int radio) {
        this.radio = radio;
    }

    public boolean stacksOn(Disc anotherDisc) {
        return radio < anotherDisc.radio;
    }
}
