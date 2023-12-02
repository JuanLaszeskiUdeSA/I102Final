package self;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotWarTests {
    @BeforeEach
    public void setUp() {
        aluminum3000 = new Aluminum3000();
        tankRover = new TankRover();
        blaster = new Blaster();
        claw = new Claw();
    }

    @Test public void testAluminum3000SpawnWithCorrectStats() {
        assertStats(aluminum3000, 50, 90, 100);
    }

    @Test public void testTankRoverSpawnWithCorrectStats() {
        assertStats(tankRover, 200, 40, 100);
    }

    @Test public void testAluminum3000WithClaw() {
        aluminum3000.addWeapon(claw());
        assertStats(aluminum3000, 40, 85, 100);
    }

    @Test public void testTankRoverWithClaw() {
        tankRover.addWeapon(claw());
        assertStats(tankRover, 190, 35, 100);
    }

    @Test public void testAluminum3000WithBlaster() {
        aluminum3000.addWeapon(blaster());
        assertStats(aluminum3000, 30, 80, 100);
    }

    @Test public void testTankRoverWithBlaster() {
        tankRover.addWeapon(blaster());
        assertStats(tankRover, 180, 30, 100);
    }

    @Test public void testAluminum3000WithClawAndBlaster() {
        aluminum3000.addWeapon(claw()).addWeapon(blaster());
        assertStats(aluminum3000, 20, 75, 100);
    }

    @Test public void testTankRoverWithClawAndBlaster() {
        tankRover.addWeapon(claw()).addWeapon(blaster());
        assertStats(tankRover, 170, 25, 100);
    }

    @Test public void testCannotCloneWeapons() {
        aluminum3000.addWeapon(claw);
        assertThrowsLike(() -> aluminum3000.addWeapon(claw), Robot.NoSePuedeClonarArmas);
    }

    @Test public void testCanAddTwoDifferentClaws() {
        aluminum3000.addWeapon(claw()).addWeapon(claw());
        assertStats(aluminum3000, 30, 80, 100);
    }

    @Test public void testCanAddTwoDifferentBlasters() {
        aluminum3000.addWeapon(blaster()).addWeapon(blaster());
        assertStats(aluminum3000, 10, 70, 100);
    }

    @Test public void testAluminum3000IsDestroyedByOverCharge(){
        aluminum3000.addWeapon(blaster()).addWeapon(blaster());
        assertThrowsLike(() -> aluminum3000.addWeapon(blaster()), Robot.ElRobotHaSidoDestruidoPorSobrecarga);

    }

    @Test public void testTankRoverIsDestroyedByOverCharge(){
        tankRover.addWeapon(blaster()).addWeapon(blaster()).addWeapon(blaster()).addWeapon(blaster());
        assertThrowsLike(() -> tankRover.addWeapon(blaster()), Robot.ElRobotHaSidoDestruidoPorSobrecarga);
    }

    @Test public void testAttackWithAWeaponThatIsNotInRobotDoesNothing(){
        aluminum3000.addWeapon(claw).attackTo(tankRover, blaster);
        assertStats(tankRover, 200, 40, 100);
    }

    @Test public void testAluminum3000AttackToTankRoverWithClaw(){
        aluminum3000.addWeapon(claw).attackTo(tankRover, claw);
        assertStats(tankRover, 200, 40, 95);
    }

    @Test public void testAluminum3000AttackToTankRoverWithBlaster(){
        aluminum3000.addWeapon(blaster).attackTo(tankRover, blaster);
        assertStats(tankRover, 200, 40, 50);
    }

    @Test public void testTankRoverAttackToAluminum3000WithClaw(){
        tankRover.addWeapon(claw).attackTo(aluminum3000, claw);
        assertStats(aluminum3000, 50, 90, 75);
    }

    @Test public void testTankRoverAttackToAluminum3000WithBlaster(){
        tankRover.addWeapon(blaster).attackTo(aluminum3000, blaster);
        assertStats(aluminum3000, 50, 90, 95);
    }

    @Test public void testAluminum3000AttackToAnotherAluminum3000(){
        Aluminum3000 otherAluminum3000 = new Aluminum3000();
        aluminum3000.addWeapon(claw).addWeapon(blaster)
                .attackTo(otherAluminum3000, blaster);
        aluminum3000.attackTo(otherAluminum3000, claw);
        assertStats(otherAluminum3000, 50, 90, 70);
    }

    @Test public void testARobotIsDestroyedBySeveralAttacks(){
        aluminum3000.addWeapon(claw).addWeapon(blaster).attackTo(tankRover, blaster);
        assertThrowsLike(() -> aluminum3000.attackTo(tankRover, blaster), Robot.ElJuegoHaTerminado);
    }

    @Test public void testAttackWithClawThatHasBeenUsedTwiceInAluminum3000DoesNotNothingInTheThirdHitAnThen(){
        Aluminum3000 otherAluminum3000 = new Aluminum3000();
        aluminum3000.addWeapon(claw).attackTo(otherAluminum3000, claw);
        aluminum3000.attackTo(otherAluminum3000, claw);
        aluminum3000.attackTo(otherAluminum3000, claw);
        aluminum3000.attackTo(otherAluminum3000, claw);
        assertStats(otherAluminum3000, 50, 90, 50);
    }

    @Test public void testAttackWithClawThatHasBeenUsedOnceInTankRoverDoesNotNothingThen(){
        aluminum3000.addWeapon(claw).attackTo(tankRover, claw);
        aluminum3000.attackTo(tankRover, claw);
        assertStats(tankRover, 200, 40, 95);

    }

    private Claw claw(){return new Claw();}
    private Blaster blaster(){return new Blaster();}

    private void assertStats(Robot robot, int expectedCarryWeight, int expectedVelocity, int expectedLifeTime) {
        assertEquals(expectedCarryWeight, robot.getCarryWeight());
        assertEquals(expectedVelocity, robot.getVelocity());
        assertEquals(expectedLifeTime, robot.getLifeTime());
    }

    private void assertThrowsLike(Executable executable, String message ) {
        assertEquals( message, assertThrows( Exception.class, executable ).getMessage() );
    }

    private Aluminum3000 aluminum3000;
    private TankRover tankRover;
    private Claw claw;
    private Blaster blaster;
}
