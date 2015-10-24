package com.inoutcorp.cpq.opportunity.utils;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DateTest {

	public static void main(String args[]) {
		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d = new Date(calendar.getTimeInMillis());
		output.setTimeZone(TimeZone.getTimeZone("GMT"));
		output.format(d);

		System.out.println(output.format(d));

	}
}
