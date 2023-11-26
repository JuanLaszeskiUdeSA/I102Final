package robotWar;

public class Weapon {
    private int velocityImpact;
    private int weight;
    public Weapon(int velocityImpact, int weight) {
        this.velocityImpact = velocityImpact;
        this.weight = weight;
    }

    public int getVelocityImpact() {return velocityImpact;}
    public int getWeight() {return weight;}
}
