package agenda;

import java.time.LocalDate;

public class VacationPeriod extends Holiday {
	private LocalDate startDate;
	private LocalDate endDate;
	
	public VacationPeriod( LocalDate firstDate, LocalDate lastDay){
		startDate = firstDate;
		endDate = lastDay;
	}

	public boolean isHoliday(LocalDate date) {
		return isDateBetween( date, startDate, endDate);
	}

	private boolean isDateBetween(LocalDate date, LocalDate startDate2, LocalDate endDate2) {
		return (date.isEqual( startDate) || date.isAfter( startDate))
				&& (date.isEqual(endDate) || date.isBefore(endDate));
	}
}
