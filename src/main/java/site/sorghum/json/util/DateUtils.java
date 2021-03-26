package site.sorghum.json.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Author: Sorghum
 * @Date: 2021/3/25 15:36
 */
public class DateUtils {
    private final static int STANDARD_TIMESTAMP_LENGTH = 13;

    public static String dateFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }


    public static Date stringToDate(String str) throws ParseException {
        return stringToDate(str,"yyyy-MM-dd HH:mm:ss");
    }
    public static Date stringToDate(String str,String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(str);
    }


    public static String cstFormat(String str) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = formatter.parse(str);
        return dateFormat(date);
    }


    public static Date longToDate(long str) throws ParseException {
        if (String.valueOf(str).length() != STANDARD_TIMESTAMP_LENGTH) {
            return new Date(str * 1000);
        }
        return new Date(str);

    }
}
