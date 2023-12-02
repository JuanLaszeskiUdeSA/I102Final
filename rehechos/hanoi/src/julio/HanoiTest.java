package julio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class HanoiTest {
		
	@Test
	public void test01AddElementToNewStick() {
		
		Disc aDisc = new Disc();
		assertEquals (aDisc, new Stick().push(aDisc).top());		
	}	
	
	@Test
	public void test02AddASecondElement() {
		Disc bigDisc = new Disc(3);
		Disc smallDisc = new Disc(2);
		Stick aStick = new Stick().push(bigDisc);
		aStick.push(smallDisc);
		
		assertEquals(smallDisc, aStick.pop());
		assertEquals(bigDisc, aStick.top());	
	}
	
	@Test
	public void test03FailWhenAddingABiggerElement() {
		Disc bigDisc = new Disc(3);
		Disc smallDisc = new Disc(2);
		Stick aStick = new Stick().push(smallDisc);
		try {
			aStick.push(bigDisc);
			fail("this should fail");
		}catch(Exception e) {
			assertEquals("forbidden move", e.getMessage());
		}	
	}
	
	@Test
	public void test04ASmallDiscStacksOverABigDisc() {
		assertTrue(new Disc(3).stacksOn(new Disc(4)));
	}
	
	@Test
	public void test05ABigDiscDoesNotStacksOverASmallDisc() {
		assertFalse(new Disc(4).stacksOn(new Disc(3)));
	}
	
	/*@Test
	public void test06() {
		
		Stick stickRight = new Stick();
		stickRight.push(new Disc(3));
		Hanoi hanoi = new Hanoi(new Stick(), new Stick(), stickRight);
		
		hanoi.moveRL();
		
		assertEquals(new Disc(3), hanoi.left().top());
	}*/
}
