package julio;

public class TankRover extends Robot {

	public int speed() {
		return 40;
	}
	
	public int maxWeaponWeight() {
		return 200;
	}

	protected void attackedWith(Weapon aWeapon, Robot anAttacker) {
		aWeapon.attackTankRover(this, anAttacker);
		
	}

}
