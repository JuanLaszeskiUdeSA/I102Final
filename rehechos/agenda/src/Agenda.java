import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Holiday> holidays;

    public Agenda() {
        this.holidays = new ArrayList<>();
    }

    public void addSpecificHoliday(LocalDate start) {
        holidays.add(new SpecificHoliday(start, start));
    }

    public void addPeriodHoliday(LocalDate start, LocalDate end) {
        holidays.add(new PeriodHoliday(start, end));
    }

    public void addWeeklyHoliday(DayOfWeek dayOfWeek) {
        holidays.add(new WeeklyHoliday(dayOfWeek));
    }

    public boolean isHoliday(LocalDate date) {
        return holidays.stream().anyMatch(holiday -> holiday.matches(date));
    }
}
