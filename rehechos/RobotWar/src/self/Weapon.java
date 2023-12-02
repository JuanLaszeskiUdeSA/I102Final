package self;

public abstract class Weapon {
    private int weight;
    private int velocityImpact;
    private int usedTimes;

    public Weapon(int weight, int velocityImpact) {
        this.weight = weight;
        this.velocityImpact = velocityImpact;
    }

    public int getWeight() {
        return weight;
    }

    public int getVelocityImpact() {
        return velocityImpact;
    }

    public void damageTo(Robot receiver, Robot attacker) {
        usedTimes++;
        receiver.attackedBy(this, attacker);
    }

    public int getUsedTimes() {
        return usedTimes;
    }


    public abstract void damageAluminum3000(Robot robot, Robot attacker);

    public abstract void damageTankRover(Robot robot, Robot attacker);
}
