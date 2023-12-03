package agenda;

import java.time.LocalDate;

public class SpecificHoliday extends Holiday{
	private LocalDate holidayDate;
	
	public SpecificHoliday( LocalDate specificHoliday ) {
		holidayDate = specificHoliday;
	}

	public boolean isHoliday( LocalDate date) {
		return holidayDate.equals( date );
	}
}
