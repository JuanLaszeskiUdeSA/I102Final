package julio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class RobotTest{
	Robot attackedAl;
	Robot attackerAl;
	Robot attackedTank;
	
	@BeforeEach
	public void setup() {
		attackedAl = createAluminum3000();
		attackerAl = createAluminum3000();
		attackedTank = createTankRover();
	}

	@Test
	public void test01ShouldHaveZeroWeightImpactWhenNoWeaponsAdded() {
			assertEquals(0, createTankRover().totalWeaponWeight()); 
	}

	@Test
	public void test02ShouldAddWeightWhenAddingWeapon() {
	    Robot robot = createTankRover(); 
	    robot.addWeapon(createBlaster());

	    assertEquals(createBlaster().weight(), robot.totalWeaponWeight());
	}
	
	@Test
	public void test03ShouldHaveZeroSpeedImpactWhenNoWeaponsAdded() {
		assertEquals(0, createTankRover().totalSpeedImpact()); 
	}
	
	@Test
    public void test04ShouldAddSpeedImpactWhenAddingWeapons() {
        Robot robot = createTankRover();
       
        robot.addWeapon(createBlaster());
        robot.addWeapon(createClaw());
        assertEquals(15, robot.totalSpeedImpact());
    }
	
	 @Test
	    public void test05ShouldNotAddWeaponIfMaxWeaponWeightExceeded() {
	        Robot robot = createAluminum3000();
	        Weapon addedWeapon1 = createBlaster();
	        Weapon addedWeapon2 = createBlaster();
	        Weapon addedWeapon3 = createBlaster();
	        robot.addWeapon(addedWeapon1);
	        robot.addWeapon(addedWeapon2);       

			assertThrowsLike(() -> robot.addWeapon(addedWeapon3),
					Robot.maxWeaponWeightExceededErrorDescription);        
	        
			assertEquals(2, robot.weaponsCount());
	        assertTrue(robot.includesWeapon(addedWeapon1));
	        assertTrue(robot.includesWeapon(addedWeapon2));
	        assertFalse(robot.includesWeapon(addedWeapon3));
	        assertEquals(40, robot.totalWeaponWeight());
	    }
	 
	 @Test
	 public void test06ShouldNotAddWeaponIfSpeedBelowZero() {
		    Robot robot = createTankRover();
		    robot.addWeapon(createBlaster());
		    robot.addWeapon(createBlaster());
		    robot.addWeapon(createBlaster());
		    robot.addWeapon(createBlaster());

			assertThrowsLike(() -> robot.addWeapon(createBlaster()),
					Robot.speedBelowZeroErrorDescription);
	        
			assertEquals(4, robot.weaponsCount());
		    assertEquals(40, robot.totalSpeedImpact());
		}
	 
	 @Test
	 public void test07clawReducesLifeOfAluminum3000By25() {
		 
		 Weapon attackerWeapon = createClaw();
		 attackerAl.addWeapon(attackerWeapon);
		 
		 attackerAl.attack(attackedAl,attackerWeapon);
		 
		 assertEquals(75, attackedAl.getLife() );	 
		}

	 @Test
	 public void test08clawReducesLifeOfTankRoverBy5() {
		 
		 Weapon attackerWeapon = createClaw();
		 attackerAl.addWeapon(attackerWeapon);
		 
		 attackerAl.attack(attackedTank,attackerWeapon);
		 
		 assertEquals(95, attackedTank.getLife() );		 
		}
	 
	 @Test
	 public void test09blasterReducesLifeOfAluminum3000By5() {
		 
		 Weapon attackerWeapon = createBlaster();
		 attackerAl.addWeapon(attackerWeapon);
		 
		 attackerAl.attack(attackedAl,attackerWeapon);
		 
		 assertEquals(95, attackedAl.getLife() );	 
		}

	 @Test
	 public void test10blasterReducesLifeOfTankRoverBy50() {
		 
		 Weapon attackerWeapon = createBlaster();
		 attackerAl.addWeapon(attackerWeapon);
		 
		 attackerAl.attack(attackedTank,attackerWeapon);
		 
		 assertEquals(50, attackedTank.getLife() );
		}

	 @Test
	 public void test11CanUseClawOnlyTwiceWhenAttackingAluminum3000() {

		 Weapon attackerWeapon = createClaw();
		 attackerAl.addWeapon(attackerWeapon);
		 
		 attackerAl.attack(attackedAl,attackerWeapon);
		 attackerAl.attack(attackedAl,attackerWeapon);
		 
		assertThrowsLike(() -> attackerAl.attack(attackedAl,attackerWeapon),
					Robot.canNotAttackWithWeaponNotBelongingToRobotErrorDescription);
	 }
	 
	 @Test
	 public void test12CanUseClawOnlyTwiceWhenAttackingTankRover() {
		 
		 Weapon attackerWeapon = createClaw();
		 attackerAl.addWeapon(attackerWeapon);
		 
		 attackerAl.attack(attackedTank,attackerWeapon);

		assertThrowsLike(() -> attackerAl.attack(attackedTank,attackerWeapon),
					Robot.canNotAttackWithWeaponNotBelongingToRobotErrorDescription);
	 }
	 
	 private Robot createAluminum3000() {
		return new Aluminum3000();
	}

	private Weapon createClaw() {
		return new Claw();
	}
	
	private Robot createTankRover() {
		return new TankRover();
	}
	
	private Weapon createBlaster() {
		return new Blaster();
	}
	
	private void assertThrowsLike(Executable executable, String message) {
		assertEquals(message, assertThrows(Error.class, executable).getMessage());
	}
}
