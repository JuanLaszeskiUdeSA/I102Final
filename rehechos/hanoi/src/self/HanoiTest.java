package self;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HanoiTest {
    @BeforeEach
    public void setUp() {
        bigDisc = new Disc(3);
        smallDisc = new Disc(2);
    }

    @Test
    public void test01AddElementToNewStick() {
        assertEquals(bigDisc, new Stick().push(bigDisc).top());
    }

    @Test
    public void test02AddASecondElement() {
        Stick aStick = new Stick().push(bigDisc);
        aStick.push(smallDisc);
        assertEquals(smallDisc, aStick.pop());
        assertEquals(bigDisc, aStick.top());
    }

    @Test
    public void test03FailWhenAddingABiggerElement() {
        Stick aStick = new Stick().push(smallDisc);
        assertThrows(RuntimeException.class, () -> aStick.push(bigDisc));
    }

    @Test
    public void test04ASmallDiscStacksOverABigDisc() {
        assertTrue(smallDisc.stacksOn(bigDisc));
    }

    @Test
    public void test05ABigDiscDoesNotStacksOverASmallDisc() {
        assertFalse(bigDisc.stacksOn(smallDisc));
    }

    @Test
    public void test06() {
        Stick stickRight = new Stick();
        stickRight.push(bigDisc);
        Hanoi hanoi = new Hanoi();
        hanoi.moveRL();
        assertEquals(bigDisc, hanoi.getStickRight().top());
    }


    private Disc bigDisc;
    private Disc smallDisc;
}
