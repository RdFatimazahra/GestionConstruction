package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date convertStringToSqlDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = format.parse(dateStr);
            return new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

