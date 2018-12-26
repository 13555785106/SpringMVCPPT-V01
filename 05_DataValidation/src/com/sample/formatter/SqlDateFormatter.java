package com.sample.formatter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.format.Formatter;

public class SqlDateFormatter implements Formatter<Date> {
	private SimpleDateFormat dateFormat;

	public SqlDateFormatter(String datePattern) {
		this.dateFormat = new SimpleDateFormat(datePattern);
	}

	@Override
	public String print(Date date, Locale locale) {
		if (date != null)
			return dateFormat.format(date);
		return null;
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		if (text != null)
			return new Date(dateFormat.parse(text).getTime());
		return null;
	}

}
