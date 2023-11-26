package robotWar;

public class Claw extends Weapon{
    public Claw(int velocityImpact, int weight) {
        super(velocityImpact, weight);
    }

    public static Claw create(){
        return new Claw(5, 10);
    }
}
