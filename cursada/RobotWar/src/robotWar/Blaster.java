package robotWar;

public class Blaster extends Weapon{
    public Blaster(int velocityImpact, int weight) {
        super(velocityImpact, weight);
    }

    public static Blaster create(){
        return new Blaster(10, 20);
    }
}
