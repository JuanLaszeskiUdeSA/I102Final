import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Agenda {
	private List<Holiday> holidays;
	
	public Agenda() {
		holidays = new ArrayList<Holiday>();
	}

	public Agenda registerSpecificHoliday(LocalDate date) {
		holidays.add( new SpecificHoliday( date ) );
		return this;
	}

	public Agenda registerWeeklyHoliday(DayOfWeek day) {
		holidays.add( new WeeklyHoliday( day ) );
		return this;	
	}
	
	public Agenda registerPeriodHoliday(LocalDate startDate, LocalDate endDate) {
		holidays.add( new VacationPeriod( startDate, endDate ) );
		return this;
	}
	
	public boolean isHoliday(LocalDate date) {
		return holidays.stream().anyMatch( each -> each.isHoliday( date ));
	}
}
