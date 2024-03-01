package ch10.date_and_time;

import java.util.Calendar;
import java.util.Date;

public class DateAndCalendarConversion {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        System.out.println(d1.toString());
        d1 = new Date(calendar.getTimeInMillis());
        System.out.println(d1.toString());

        Date date = new Date();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        System.out.println(toString(cal1));
    }

    public static String toString (Calendar date) {
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH)+1) + "월 " + date.get(Calendar.DATE) +"일 ";
    }
}
