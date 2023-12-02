package self;

public class TankRover extends Robot {
    public TankRover() {
        super(200, 40, 100);
    }


    @Override
    protected void attackedBy(Weapon aWeapon, Robot attacker) {
        aWeapon.damageTankRover(this, attacker);
    }
}
