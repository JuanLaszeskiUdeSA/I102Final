import java.time.LocalDate;

public class SpecificHoliday extends Holiday{
    public SpecificHoliday(LocalDate start, LocalDate end) {
        super(start, start);
    }

    @Override
    public boolean matches(LocalDate date) {
        return date.equals(getStart());
    }


}
