package com.inoutcorp.cpq.opportunity.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

	public static void main(String args[]) throws ParseException {
		System.out.println("--- " + between5Mins(new Date()));
	}

	public static boolean between5Mins(Date apiDate) throws ParseException {

		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTimeInMillis(System.currentTimeMillis());
		localCalendar.add(Calendar.MINUTE, -5);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		sdf.format(localCalendar.getTime());

		System.out.println("Current Time "
				+ sdf.format(localCalendar.getTime()));
		System.out.println("SFDC Time " + apiDate);

		return apiDate.after(sdf.parse(sdf.format(localCalendar.getTime())));
	}

	public static String fiveMinsBeforeDate() {

		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTimeInMillis(System.currentTimeMillis());
		localCalendar.add(Calendar.MINUTE, -5);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		sdf.format(localCalendar.getTime());

		System.out.println("Current Time "
				+ sdf.format(localCalendar.getTime()));

		return sdf.format(localCalendar.getTime());
	}
}
