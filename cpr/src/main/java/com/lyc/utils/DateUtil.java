package com.lyc.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date parse(String strDate,String format) {
		   SimpleDateFormat formatter = new SimpleDateFormat(format);
		   ParsePosition pos = new ParsePosition(0);
		   Date strtodate = formatter.parse(strDate, pos);
		   return strtodate;
		}
}
