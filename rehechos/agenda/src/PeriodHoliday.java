import java.time.LocalDate;

public class PeriodHoliday extends Holiday{
    public PeriodHoliday(LocalDate start, LocalDate end) {
        super(start, end);
    }

    @Override
    public boolean matches(LocalDate date) {
        return date.equals(getStart()) || date.equals(getEnd())
                || (date.isAfter(getStart()) && date.isBefore(getEnd()));
    }
}
