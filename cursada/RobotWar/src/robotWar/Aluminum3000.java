package robotWar;

public class Aluminum3000 extends Robot {

    public Aluminum3000(int lifeTime, int velocity, int carryWeight) {
        super(lifeTime, velocity, carryWeight);
    }

    public static Aluminum3000 spawn(){
        return new Aluminum3000(100, 90, 50);
    }
}
