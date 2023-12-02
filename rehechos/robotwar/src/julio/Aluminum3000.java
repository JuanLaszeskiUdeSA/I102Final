package julio;

public class Aluminum3000 extends Robot {

	@Override
	public int speed() {
		return 90;
	}
	
	public int maxWeaponWeight() {
		return 50;
	}

	protected void attackedWith(Weapon aWeapon, Robot anAttacker) {
		aWeapon.attackAluminum3000(this, anAttacker);		
	}
}

