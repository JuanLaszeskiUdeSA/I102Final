import java.time.LocalDate;

public class PeriodHoliday extends Holiday{
    private LocalDate startDate;
    private LocalDate endDate;

    public PeriodHoliday(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return aDate.equals(startDate) || aDate.equals(endDate) ||
                aDate.isAfter(startDate) && aDate.isBefore(endDate);
    }
}
