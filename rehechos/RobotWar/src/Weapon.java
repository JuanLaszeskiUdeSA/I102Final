import java.util.List;

public abstract class Weapon {
    private int weight;
    private int velocityImpact;

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

    public abstract void damageTo(Robot receiver);

}
