import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.DayOfWeek;
import static org.junit.jupiter.api.Assertions.*;

public class AgendaTest {

    @BeforeEach public void setUp() {
        agenda = new Agenda();
        christmas19 = LocalDate.of(2019, 12, 25);
        newYear20 = LocalDate.of(2020, 1, 1);
        sunday29Oct = LocalDate.of(2023, 10, 29);
        Sunday = DayOfWeek.SUNDAY;
        Saturday = DayOfWeek.SATURDAY;
    }

    @Test public void testNewAgendaIsEmpty() {
        assertTrue(agenda.isEmpty());
    }

    @Test public void testAddASingularHolidayHoliday() {
        agenda.addSingularHoliday(christmas19);
        assertTrue(agenda.isHoliday(LocalDate.of(2019, 12, 25)));
    }

    @Test public void testAddAWeeklyHoliday() {
        agenda.addWeeklyHoliday(Sunday);
        assertTrue(agenda.isHoliday(sunday29Oct));
    }

    @Test public void testAddAPeriodHolidayAndAskStartDate() {
        agenda.addPeriodHoliday(christmas19, newYear20);
        assertTrue(agenda.isHoliday(christmas19));
    }

    @Test public void testAddAPeriodHolidayAndAskEndDate() {
        agenda.addPeriodHoliday(christmas19, newYear20);
        assertTrue(agenda.isHoliday(newYear20));
    }

    @Test public void testAddAPeriodHolidayAndAskDateInBetween() {
        agenda.addPeriodHoliday(christmas19, newYear20);
        assertTrue(agenda.isHoliday(LocalDate.of(2019, 12, 31)));
    }

    @Test public void testIsHolidayReturnsFalseIfHolidayIsNotRegistered() {
        assertFalse(agenda.isHoliday(LocalDate.now()));
    }

    @Test public void testIsHolidayReturnsFalseIfWrongDateIsAskedForSpecificHoliday() {
        agenda.addSingularHoliday(christmas19);
        assertFalse(agenda.isHoliday(LocalDate.of(2019, 12, 24)));
    }

    @Test public void testIsHolidayReturnsFalseIfWrongDateIsAskedForWeeklyHoliday() {
        agenda.addWeeklyHoliday(Sunday);
        assertFalse(agenda.isHoliday(LocalDate.of(2023, 10, 28)));
    }

    @Test public void testIsHolidayReturnsFalseIfWrongDateIsAskedForPeriodHoliday() {
        agenda.addPeriodHoliday(christmas19, newYear20);
        assertFalse(agenda.isHoliday(LocalDate.of(2019, 12, 24)));
    }

    @Test public void testRegisteringAnExistentSpecificHolidayDoesNotThrowError() {
        agenda.addSingularHoliday(christmas19);
        assertTrue(agenda.addSingularHoliday(christmas19).isHoliday(christmas19));
    }

    @Test public void testRegisteringAnExistentWeeklyHolidayDoesNotThrowError() {
        agenda.addWeeklyHoliday(Sunday);
        assertTrue(agenda.addWeeklyHoliday(Sunday).isHoliday(sunday29Oct));
    }

    @Test public void testRegisteringAnExistentPeriodHolidayTwiceDoesNotThrowError() {
        agenda.addPeriodHoliday(christmas19, newYear20);
        assertTrue(agenda.addPeriodHoliday(christmas19, newYear20).isHoliday(christmas19));
    }

    @Test public void testRegisteringAWeeklyHolidayWithAnExistentSpecificHolidayDoesNotThrowError() {
        agenda.addSingularHoliday(sunday29Oct);
        assertTrue(agenda.addWeeklyHoliday(Sunday).isHoliday(sunday29Oct));
    }

    @Test public void testRegisteringAnExistentASpecificHolidayWeeklyHolidayDoesNotThrowError() {
        agenda.addWeeklyHoliday(Sunday);
            assertTrue(agenda.addSingularHoliday(christmas19).isHoliday(sunday29Oct));
    }

    @Test public void testRegisteringAnExistentPeriodHolidayOnAWeeklyHolidayDoesNotThrowError() {
        agenda.addWeeklyHoliday(Sunday);
        assertTrue(agenda.addPeriodHoliday(sunday29Oct, sunday29Oct).isHoliday(sunday29Oct));
    }




    private Agenda agenda;
    private LocalDate christmas19;
    private LocalDate newYear20;
    private LocalDate sunday29Oct;
    private DayOfWeek Sunday;
    private DayOfWeek Saturday;
}
