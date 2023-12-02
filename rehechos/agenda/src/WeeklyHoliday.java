import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklyHoliday extends Holiday{
    public WeeklyHoliday(DayOfWeek aDayOfWeek) {
        super(aDayOfWeek);
    }

    @Override
    public boolean matches(LocalDate date) {
        return date.getDayOfWeek() == getDayOfWeek();
    }
}
