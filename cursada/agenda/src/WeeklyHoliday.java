import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklyHoliday extends Holiday{
    private DayOfWeek dayOfWeek;
    public WeeklyHoliday(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isHoliday(LocalDate aDate) {
        return this.dayOfWeek.equals(aDate.getDayOfWeek());
    }
}
