package ch10.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodAndDurationEx {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2014,1,1);
        LocalDate date2 = LocalDate.of(2015,12,31);

        Period pe = Period.between(date1, date2);

        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
        System.out.println("pe = " + pe);

        System.out.println("pe.get(ChronoUnit.YEARS) = " + pe.get(ChronoUnit.YEARS));
        System.out.println("pe.get(ChronoUnit.MONTHS) = " + pe.get(ChronoUnit.MONTHS));

        LocalTime time1 = LocalTime.of(0,0,0);
        LocalTime time2 = LocalTime.of(12,34,56);

        Duration du = Duration.between(time1, time2);

        System.out.println("time1 = " + time1);
        System.out.println("time2 = " + time2);
        System.out.println("du = " + du);

        LocalTime tmpTime = LocalTime.of(0,0).plusSeconds(du.getSeconds());

        System.out.println("tmpTime.getHour() = " + tmpTime.getHour());
        System.out.println("tmpTime.getMinute() = " + tmpTime.getMinute());
    }
}
