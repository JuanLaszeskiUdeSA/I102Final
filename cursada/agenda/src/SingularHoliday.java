import java.time.LocalDate;

public class SingularHoliday extends Holiday{
    private LocalDate holidayDate;

    public SingularHoliday(LocalDate holidayDate) {
        this.holidayDate = holidayDate;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return this.holidayDate.equals(aDate);
    }
}
