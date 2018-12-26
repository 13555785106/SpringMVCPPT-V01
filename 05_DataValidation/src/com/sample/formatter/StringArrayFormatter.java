package com.sample.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class StringArrayFormatter implements Formatter<String[]> {
	private String arraySeparator = ",";

	public StringArrayFormatter() {
	}

	public StringArrayFormatter(String arraySeparator) {
		this.arraySeparator = arraySeparator;
	}

	@Override
	public String print(String[] strs, Locale locale) {
		if (strs != null) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < strs.length; i++) {
				sb.append(strs[i]);
				if (i < strs.length - 1)
					sb.append(arraySeparator);
			}
			return sb.toString();
		}
		return null;
	}

	@Override
	public String[] parse(String str, Locale locale) throws ParseException {
		if (str != null)
			return str.split(arraySeparator);
		return null;
	}
}
