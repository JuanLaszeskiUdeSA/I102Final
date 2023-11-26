package robotWar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class RobotWarTest {

    @BeforeEach
    public void setUp() {
        aluminum3000 = Aluminum3000.spawn();
        tankRover = TankRover.spawn();
    }

    @Test
    public void testNewAluminum3000HasCorrectStatsAndDoesNotHaveWeapons() {
        assertStats(100, 90, 50, aluminum3000);
        assertFalse(aluminum3000.hasWeapons());
    }

    @Test
    public void testNewTankRoverHasCorrectStatsAndDoesNotHaveWeapons() {
        assertStats(100, 40, 200, tankRover);
        assertFalse(tankRover.hasWeapons());
    }

    @Test
    public void testAddAClawToAluminum3000ProducesExceptedImpacts() {
        aluminum3000.addWeapon(Claw.create());
        assertStats(100, 85, 40, aluminum3000);
    }

    @Test
    public void testAddABlasterToAluminum3000ProducesExceptedImpacts() {
        aluminum3000.addWeapon(Blaster.create());
        assertStats(100, 80, 30, aluminum3000);
    }

    @Test
    public void testAddAClawToTankRoverProducesExceptedImpacts() {
        tankRover.addWeapon(Claw.create());
        assertStats(100, 35, 190, tankRover);
    }

    @Test
    public void testAddABlasterToTankRoverProducesExceptedImpacts() {
        tankRover.addWeapon(Blaster.create());
        assertStats(100, 30, 180, tankRover);
    }

    @Test
    public void testAddAClawAndBlasterToAluminum3000ProducesExceptedImpacts() {
        aluminum3000.addWeapon(Claw.create());
        aluminum3000.addWeapon(Blaster.create());
        assertStats(100, 75, 20, aluminum3000);
    }

    @Test
    public void testAddAClawAndBlasterToTankRoverProducesExceptedImpacts() {
        tankRover.addWeapon(Claw.create());
        tankRover.addWeapon(Blaster.create());
        assertStats(100, 25, 170, tankRover);
    }

    @Test
    public void testDestroyAAluminum3000ByOverCharge() {
        aluminum3000.addWeapon(Blaster.create()).addWeapon(Blaster.create());
        assertThrowsLike( () -> aluminum3000.addWeapon(Blaster.create()), Robot.RobotHasBeenDestroyedBecauseOfOverCharge);
    }

    @Test
    public void testDestroyATankRoverByOverCharge() {
        addAWeaponManyTimes(tankRover, Blaster::create, 3);
        assertThrowsLike( () -> tankRover.addWeapon(Blaster.create()), Robot.RobotHasBeenDestroyedBecauseOfOverCharge);
    }

    private Robot addAWeaponManyTimes(Robot robot, Runnable weaponCreation, int times) {
        IntStream.range(0, times).forEach(i -> {
            Weapon weapon = weaponCreation.run();
            robot.addWeapon(weapon);
        }
        return robot;
    }

    private void assertStats(int expectedLifeTime, int expectedVelocity, int expectedCarryWeight, Robot robot) {
        assertEquals(expectedLifeTime, robot.getLifeTime());
        assertEquals(expectedVelocity, robot.getVelocity());
        assertEquals(expectedCarryWeight, robot.getCarryWeight());
    }

    private void assertThrowsLike(Executable executable, String message ) {
        assertEquals( message,
                assertThrows( Exception.class, executable ).getMessage() );
    }


    private Aluminum3000 aluminum3000;
    private TankRover tankRover;
}

