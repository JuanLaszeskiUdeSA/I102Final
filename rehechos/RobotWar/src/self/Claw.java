package self;

public class Claw extends Weapon {

    public Claw() {
        super(10, 5);
    }

    @Override
    public void damageAluminum3000(Robot robot, Robot attacker) {
        if (getUsedTimes() == 2) {
            attacker.removeWeapon(this);
        }
        robot.reduceLife(25);
    }

    @Override
    public void damageTankRover(Robot robot, Robot attacker) {
        attacker.removeWeapon(this);
        robot.reduceLife(5);
    }
}
