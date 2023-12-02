public class Aluminum3000 extends Robot {
    public Aluminum3000() {
        super(50, 90, 100);
    }

    @Override
    protected void damagedByBlaster() {
        super.setLifeTime(super.getLifeTime() - 5);
    }

    @Override
    protected void damagedByClaw(Claw aClaw) {
        super.setLifeTime(super.getLifeTime() - 25);
        aClaw.addUseInAluminum3000();
    }
}
