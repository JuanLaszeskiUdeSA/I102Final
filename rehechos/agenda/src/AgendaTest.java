import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AgendaTest {
    @Test public void testAddAnSpecificHoliday() {
        Agenda agenda = new Agenda();
        agenda.addSpecificHoliday(LocalDate.of(2023, 12, 2));
        assertTrue(agenda.isHoliday(LocalDate.of(2023, 12, 2)));
    }

    @Test public void testAddAnSpecificHolidayAndAskAnotherDay() {
        Agenda agenda = new Agenda();
        agenda.addSpecificHoliday(LocalDate.of(2023, 12, 2));
        assertFalse(agenda.isHoliday(LocalDate.of(2023, 12, 3)));
    }

    @Test public void testAddAWeeklyHoliday() {
        Agenda agenda = new Agenda();
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        assertTrue(agenda.isHoliday(LocalDate.of(2023, 12, 3)));
    }

    @Test public void testAddAWeeklyHolidayAndAskAnotherDay() {
        Agenda agenda = new Agenda();
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        assertFalse(agenda.isHoliday(LocalDate.of(2023, 12, 4)));
    }

    @Test public void testAddAPeriodHolidayAndAskADayInTheMiddle() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2023, 12, 2), LocalDate.of(2023, 12, 4));
        assertTrue(agenda.isHoliday(LocalDate.of(2023, 12, 3)));
    }

    @Test public void testAddAPeriodHolidayAndAskADayInTheEnd() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2023, 12, 2), LocalDate.of(2023, 12, 4));
        assertTrue(agenda.isHoliday(LocalDate.of(2023, 12, 4)));
    }

    @Test public void testAddAPeriodHolidayAndAskADayInTheStart() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2023, 12, 2), LocalDate.of(2023, 12, 4));
        assertTrue(agenda.isHoliday(LocalDate.of(2023, 12, 2)));
    }

    @Test public void testAddAPeriodHolidayAndAskADayBefore() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2023, 12, 2), LocalDate.of(2023, 12, 4));
        assertFalse(agenda.isHoliday(LocalDate.of(2023, 12, 1)));
    }

    @Test public void testAddAPeriodHolidayAndAskADayAfter() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2023, 12, 2), LocalDate.of(2023, 12, 4));
        assertFalse(agenda.isHoliday(LocalDate.of(2023, 12, 5)));
    }

    @Test public void testAddASpecificHolidayTwiceDoesNotChangeTheResult() {
        Agenda agenda = new Agenda();
        agenda.addSpecificHoliday(LocalDate.of(2023, 12, 2));
        agenda.addSpecificHoliday(LocalDate.of(2023, 12, 2));
        assertTrue(agenda.isHoliday(LocalDate.of(2023, 12, 2)));
    }

    @Test public void testAddAWeeklyHolidayTwiceDoesNotChangeTheResult() {
        Agenda agenda = new Agenda();
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        assertTrue(agenda.isHoliday(LocalDate.of(2023, 12, 3)));
    }

    @Test public void testAddAPeriodHolidayTwiceDoesNotChangeTheResult() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2023, 12, 2), LocalDate.of(2023, 12, 4));
        agenda.addPeriodHoliday(LocalDate.of(2023, 12, 2), LocalDate.of(2023, 12, 4));
        assertTrue(agenda.isHoliday(LocalDate.of(2023, 12, 3)));
    }

    @Test public void testAddASpecificHolidayAndAskADayInTheMiddleOfAWeeklyHoliday() {
        Agenda agenda = new Agenda();
        agenda.addSpecificHoliday(LocalDate.of(2023, 12, 2));
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        assertTrue(agenda.isHoliday(LocalDate.of(2023, 12, 3)));
    }

    @Test public void testAddAPeriodHolidayAndAskADayInTheMiddleOfAnotherPeriodWorksEqually() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2023, 12, 2), LocalDate.of(2023, 12, 4));
        agenda.addPeriodHoliday(LocalDate.of(2023, 12, 3), LocalDate.of(2023, 12, 8));
        assertTrue(agenda.isHoliday(LocalDate.of(2023, 12, 3)));
    }
}
