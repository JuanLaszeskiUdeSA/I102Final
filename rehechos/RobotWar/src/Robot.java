import java.util.ArrayList;
import java.util.List;

public abstract class Robot {
    public static String NoSePuedeClonarArmas = "No se puede clonar armas";
    public static String ElRobotHaSidoDestruidoPorSobrecarga = "El Robot ha sido destruido por sobrecarga";
    public static String ElJuegoHaTerminado = "Ya terminó el juego";
    public static String ElArmaEstaRota = "El arma está rota";

    private int carryWeight;
    private int velocity;
    private int lifeTime;
    private List<Weapon> weapons;

    public Robot(int carryWeight, int velocity, int lifeTime) {
        this.carryWeight = carryWeight;
        this.velocity = velocity;
        this.lifeTime = lifeTime;
        this.weapons = new ArrayList<>();
    }

    public Robot addWeapon(Weapon aWeapon) {
        if (carryWeight < aWeapon.getWeight() || velocity < aWeapon.getVelocityImpact()) {
            throw new RuntimeException(ElRobotHaSidoDestruidoPorSobrecarga);
        }
        else if (weapons.contains(aWeapon)) {
            throw new RuntimeException(NoSePuedeClonarArmas);
        }

        carryWeight -= aWeapon.getWeight();
        velocity -= aWeapon.getVelocityImpact();
        weapons.add(aWeapon);
        return this;
    }

    public Robot attackTo(Robot target, Weapon aWeapon) {
        if (weapons.contains(aWeapon)) {
            target.attackedBy( aWeapon);
        }
        return this;
    }

    public void attackedBy(Weapon aWeapon) {
        aWeapon.damageTo(this);
    }


    protected abstract void damagedByBlaster();

    protected abstract void damagedByClaw(Claw aClaw);

    public void setLifeTime(int lifeTime) {
        if (lifeTime <= 0) {
            throw new RuntimeException(ElJuegoHaTerminado);
        }
        this.lifeTime = lifeTime;
    }
    public int getCarryWeight() {
        return carryWeight;
    }
    public int getVelocity() {
        return velocity;
    }
    public int getLifeTime() {
        return lifeTime;
    }
}
