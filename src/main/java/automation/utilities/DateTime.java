package automation.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTime {
    public static String getCurrentDateTime(String format) {


        Date date = new Date();
        DateFormat pstFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        TimeZone timeZone = TimeZone.getTimeZone("Australia/Canberra");
        pstFormat.setTimeZone(timeZone);
        String current_date_time = pstFormat.format(date);
        System.out.println("Australia/Canberra-" + current_date_time);
        return current_date_time;


    }
}