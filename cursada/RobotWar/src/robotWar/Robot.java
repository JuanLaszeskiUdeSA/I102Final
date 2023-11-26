package robotWar;

import java.util.ArrayList;
import java.util.List;

public abstract class Robot{
    public static String RobotHasBeenDestroyedBecauseOfOverCharge = "Robot has been destroyed because of over charge";

    private int lifeTime;
    private int velocity;
    private int carryWeight;
    private List<Weapon> weapons;

    public Robot(int lifeTime, int velocity, int carryWeight){
        this.lifeTime = lifeTime;
        this.velocity = velocity;
        this.carryWeight = carryWeight;
        this.weapons = new ArrayList<Weapon>();
    }

    public Robot addWeapon(Weapon weapon){
        int velocityImpact = weapon.getVelocityImpact();
        int weightImpact = weapon.getWeight();
        if (velocityImpact > velocity || weightImpact > carryWeight){
            this.lifeTime = 0;
            setWeaponImpact(0,0);
            throw new RuntimeException(RobotHasBeenDestroyedBecauseOfOverCharge);
        }
        setWeaponImpact(velocityImpact, weightImpact);
        weapons.add(weapon);
        return this;
    }

    public void setWeaponImpact(int velocityImpact, int weightImpact){
        this.velocity -= velocityImpact;
        this.carryWeight -= weightImpact;
    }

    public int getLifeTime() {return lifeTime;}
    public int getVelocity() {return velocity;}
    public int getCarryWeight() {return carryWeight;}
    public boolean hasWeapons() {return !weapons.isEmpty();}
}
