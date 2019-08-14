package com.rcs.nchumanity.tool;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;

public class DateProce {

    /**
     * 2019-08-06T04:45:35.000+0000
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ParsePosition pos = new ParsePosition(0);
            Date strtodate = formatter.parse(strDate, pos);
            return strtodate;
         }

    public static Date parseDate(String dateStr) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
            Date result;
            result = df.parse(dateStr);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

            return result;

        }catch (Exception  e) {
        }
        return null;
    }



}
