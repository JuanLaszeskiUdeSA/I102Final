import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Agenda {
    private List<Holiday> holidays;
    public Agenda() {
        this.holidays = new ArrayList<>();
    }

    public Agenda addSingularHoliday(LocalDate aDate) {
        holidays.add(new SingularHoliday(aDate));
        return this;
    }

    public Agenda addWeeklyHoliday(DayOfWeek aDayOfTheWeek) {
        holidays.add(new WeeklyHoliday(aDayOfTheWeek));
        return this;
    }

    public Agenda addPeriodHoliday(LocalDate aStartDate, LocalDate anEndDate) {
        holidays.add(new PeriodHoliday(aStartDate, anEndDate));
        return this;
    }

    public boolean isHoliday(LocalDate aDate) {
        return holidays.stream().anyMatch(holiday -> holiday.isHoliday(aDate));
    }

    public boolean isEmpty() {return holidays.isEmpty();}
}
