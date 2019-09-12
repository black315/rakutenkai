package com.rakuten.internship.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeUtil {

	public static int calculateAge(
			String birthDate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
		LocalDate birth = LocalDate.parse(birthDate, formatter);

		LocalDate now = LocalDate.now();
		return Period.between(birth, now).getYears();
	}
}
