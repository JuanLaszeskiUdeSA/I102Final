package self;

public class Aluminum3000 extends Robot {
    public Aluminum3000() {
        super(50, 90, 100);
    }

    @Override
    protected void attackedBy(Weapon aWeapon, Robot attacker) {
        aWeapon.damageAluminum3000(this, attacker);
    }
}
