package robotWar;

public class TankRover extends Robot {

    public TankRover(int lifeTime, int velocity, int carryWeight) {
        super(lifeTime, velocity, carryWeight);
    }

    public static TankRover spawn(){
        return new TankRover(100, 40, 200);
    }
}
