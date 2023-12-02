package julio;

public abstract class Weapon {

	protected int usedTimes;
	protected abstract void attackAluminum3000(Robot aVictim, Robot anAttacker);
	protected abstract void attackTankRover(Robot aVictim, Robot anAttacker);

	public abstract int weight();
	public abstract int speedImpact();
	public void attackBy(Robot attacked, Robot attacker) {
		usedTimes = usedTimes + 1;
		attacked.attackedWith(this, attacker );
	}
}
