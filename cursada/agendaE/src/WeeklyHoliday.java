import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklyHoliday extends Holiday {
	private DayOfWeek weeklyHoliday;
	
	public WeeklyHoliday( DayOfWeek dayOfWeek ) {
		weeklyHoliday = dayOfWeek;
	}

	public boolean isHoliday( LocalDate date ) {
		return date.getDayOfWeek() == weeklyHoliday;
	}
}
