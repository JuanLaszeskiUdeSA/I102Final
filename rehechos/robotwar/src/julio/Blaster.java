package julio;

public class Blaster extends Weapon {
	
	public int weight() {
		return 20;
	}
	
	public int speedImpact() {
		return 10;
	}

	protected void attackAluminum3000(Robot aVictim, Robot anAttacker) {
		aVictim.reduceLifeBy(5);
	}

	protected void attackTankRover(Robot aVictim, Robot anAttacker) {
		aVictim.reduceLifeBy(50);		
	}
}
