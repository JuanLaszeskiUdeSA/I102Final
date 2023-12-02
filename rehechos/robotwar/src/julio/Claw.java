package julio;


public class Claw extends Weapon {
	
	public int weight() {
		return 10;
	}
	
	public int speedImpact() {
		return 5;
	}

	protected void attackAluminum3000(Robot aVictim, Robot anAttacker) {
		aVictim.reduceLifeBy(25);
		if(usedTimes == 2) {
			anAttacker.removeWeapon(this);
		}	
	}

	protected void attackTankRover(Robot aVictim, Robot anAttacker) {
		aVictim.reduceLifeBy(5);
			anAttacker.removeWeapon(this);
	}		
}

