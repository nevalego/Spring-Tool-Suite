package com.coches.services.dtos;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

import org.springframework.stereotype.Service;

@Service
public class DateConverter {

	public String dateToString(LocalDate localDate) {
		return localDate.toString("dd-MM-yyyy");
	}

	public String dateToStringWithHour(LocalDateTime localDateTime) {
		return localDateTime.toString("dd-MM-yyyy HH:mm");
	}

	public String dateToStringOnlyHour(LocalTime localTime) {
		return localTime.toString("HH:mm");
	}

	public LocalDate stringToDate(String date) {
		return LocalDate.parse(date, DateTimeFormat.forPattern("dd-MM-yyyy"));
	}

	public LocalTime stringToDateOnlyHour(String date) {
		return LocalTime.parse(date, DateTimeFormat.forPattern("HH:mm"));
	}

	public LocalDateTime stringToDateWithHour(String date) {
		return LocalDateTime.parse(date,
				DateTimeFormat.forPattern("dd-MM-yyyy HH:mm"));
	}

	public boolean compareTwoDatesWithoutYear(LocalDate first,
			LocalDate second) {
		return (first.getMonthOfYear() == second.getMonthOfYear())
				&& (first.getDayOfWeek() == second.getDayOfWeek());
	}
}