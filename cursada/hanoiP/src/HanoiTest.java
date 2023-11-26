package HanoiG1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class HanoiTest {

    @BeforeEach
    public void setUp() {
        aDisc = new Disc();
        bigDisc = new Disc(3);
        smallDisc = new Disc(2);
    }

    @Test
    public void test01AddElementToNewStick() {
        assertEquals(aDisc, new Stick().push(aDisc).top());
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

        assertEquals(assertThrows(Exception.class, () -> aStick.push(bigDisc)).getMessage(), Stick.forbiddenMove);
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
    public void test06MoveDiscsBetweenSticks() {
        Stick stickRight = new Stick();
        stickRight.push(bigDisc);

        Hanoi hanoi = new Hanoi(new Stick(), new Stick(), stickRight);
        hanoi.moveRL();

        assertEquals(bigDisc, hanoi.left().top());
    }

    private Disc aDisc;
    private Disc bigDisc;
    private Disc smallDisc;
}
