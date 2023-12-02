package julio;

import java.util.ArrayList;
import java.util.List;

public abstract class Robot {
	
	public static String speedBelowZeroErrorDescription = "Speed cannot be below zero";
	public static String maxWeaponWeightExceededErrorDescription = "Maximum weapon weight has been exceeded";
	public static String canNotAttackWithWeaponNotBelongingToRobotErrorDescription = "Cannot attack with weapon not belonging to robot";
	private int life;
	private List<Weapon> weapons;
	
	protected abstract int speed();
	protected abstract int maxWeaponWeight();
	protected abstract void attackedWith(Weapon weapon, Robot attacker);
	
	public Robot() {
        weapons = new ArrayList<>();
        life = 100;
    }

	public int totalWeaponWeight() {
	    int totalWeight = 0;
	    for (Weapon weapon : weapons) {
	        totalWeight += weapon.weight(); 
	    }
	    return totalWeight;
	}

	public int totalSpeedImpact() {
	    int totalImpact = 0;		    
	    for (Weapon weapon : weapons) {   
	            totalImpact += weapon.speedImpact(); 
	    } 
	    return totalImpact;
	}
 
	 public void addWeapon(Weapon aWeapon) {
		 assertAddingNewWeaponDoesNotPassMaxWeaponWeight(aWeapon);
		 assertAddingNewWeaponDoesNotPassSpeed(aWeapon);
		 weapons.add(aWeapon);
	 }
	
	public int weaponsCount() {
		return weapons.size();
	}

	public boolean includesWeapon(Weapon weapon) {
        return weapons.contains(weapon);
    }

	public void assertAddingNewWeaponDoesNotPassMaxWeaponWeight(Weapon aWeapon) {
	    int totalWeight = totalWeaponWeight() + aWeapon.weight();
	    int maxWeight = maxWeaponWeight(); 
	    if (totalWeight >= maxWeight) {
	        signalMaxWeaponWeightExceeded();
	    }
	}
	
	public void assertAddingNewWeaponDoesNotPassSpeed(Weapon aWeapon) {
		int totalSpeedImpact = totalSpeedImpact() + aWeapon.speedImpact();
	    if (speed()-totalSpeedImpact < 0){
	        signalSpeedBelowZero();
	    }
	}
	
	private void signalSpeedBelowZero() {
		throw new Error(speedBelowZeroErrorDescription);	
	}
	public void signalMaxWeaponWeightExceeded() {
	    throw new Error(maxWeaponWeightExceededErrorDescription);
	}
	public void reduceLifeBy(int i) {
		life = life - i;
		
	}
	public int getLife() {
		return life;
	};
	
	public void removeWeapon(Weapon aWeapon) {
	    weapons.remove(aWeapon);
	}
	public void attack(Robot attacked, Weapon attackerWeapon) {
		if(includesWeapon(attackerWeapon)) {
			attackerWeapon.attackBy(attacked, this);
		}else {
			throw new Error(canNotAttackWithWeaponNotBelongingToRobotErrorDescription);
		}	
	}	
}
