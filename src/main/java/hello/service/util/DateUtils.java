package hello.service.util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class DateUtils {
	
    DateTimeFormatter weekFormat = DateTimeFormat.forPattern("w");
    DateTimeFormatter dayShortFormat = DateTimeFormat.forPattern("MMM dd");
    DateTimeFormatter dayLongFormat = DateTimeFormat.forPattern("EEE, MMM dd");

	
	public LocalDate startOfWeek(LocalDate date) {
	    return date.dayOfWeek().withMinimumValue();
	}

	public LocalDate endOfWeek(LocalDate date) {
	    return date.dayOfWeek().withMaximumValue();
	}
	
	public String weekToString(LocalDate weekStart, LocalDate weekEnd) {
	    return "Week : "+dayShortFormat.print(weekStart)+" - "+dayShortFormat.print(weekEnd);
	}

	public String weekToId(LocalDate weekStart) {
	    return weekFormat.print(weekStart);
	}

	public String dayToShortString(LocalDate date) {
	    return dayShortFormat.print(date);
	}
	
	public String dayToLongString(LocalDate date) {
	    return dayLongFormat.print(date);
	}
	
	
	
}
