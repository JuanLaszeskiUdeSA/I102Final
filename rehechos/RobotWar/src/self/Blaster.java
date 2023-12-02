package self;

public class Blaster extends Weapon {
    public Blaster() {
        super(20, 10);
    }


    @Override
    public void damageAluminum3000(Robot robot, Robot attacker) {
        robot.reduceLife(5);
    }

    @Override
    public void damageTankRover(Robot robot, Robot attacker) {
        robot.reduceLife(50);
    }
}
