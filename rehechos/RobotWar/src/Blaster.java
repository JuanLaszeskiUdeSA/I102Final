public class Blaster extends Weapon {
    public Blaster() {
        super(20, 10);
    }

    @Override
    public void damageTo(Robot receiver) {
        receiver.damagedByBlaster();
    }
}
