public class Claw extends Weapon {
    private int usesInAluminum3000 = 0;
    private int usesInTankRover = 0;

    public Claw() {
        super(10, 5);
    }

    @Override
    public void damageTo(Robot receiver) {
        if (isBroken()) {
            throw new RuntimeException(Robot.ElArmaEstaRota);
        }
        receiver.damagedByClaw(this);
    }

    public boolean isBroken() {
        return usesInAluminum3000 >= 2 || usesInTankRover >= 1;
    }

    public void addUseInAluminum3000() {
        usesInAluminum3000++;
    }
    public void addUseInTankRover() {
        usesInTankRover++;
    }
}
