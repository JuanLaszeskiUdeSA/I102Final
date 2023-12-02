public class TankRover extends Robot {
    public TankRover() {
        super(200, 40, 100);
    }

    @Override
    protected void damagedByBlaster() {
        super.setLifeTime(super.getLifeTime() - 50);
    }

    @Override
    protected void damagedByClaw(Claw aClaw) {
        super.setLifeTime(super.getLifeTime() - 5);
        aClaw.addUseInTankRover();
    }
}
