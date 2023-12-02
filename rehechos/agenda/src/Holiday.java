import java.time.LocalDate;
import java.time.DayOfWeek;

public abstract class Holiday {
    private LocalDate start;
    private LocalDate end;
    private DayOfWeek dayOfWeek;

    public Holiday(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public Holiday(DayOfWeek aDayOfWeek) {
        this.dayOfWeek = aDayOfWeek;
    }

    public abstract boolean matches(LocalDate date);

    public LocalDate getStart() {
        return start;
    }
    public LocalDate getEnd() {
        return end;
    }
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
