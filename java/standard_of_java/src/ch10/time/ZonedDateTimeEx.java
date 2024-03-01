package ch10.time;

import java.time.*;
import java.time.temporal.ChronoField;

public class ZonedDateTimeEx {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId zid = ZoneId.of("Asia/Seoul");

        ZonedDateTime zdt = dateTime.atZone(zid);
        System.out.println("zdt = " + zdt);
        zdt = LocalDate.now().atStartOfDay(zid); // 0시 0분 0초
        System.out.println("zdt = " + zdt);

        // 현재 뉴욕 시간
        ZoneId nyId = ZoneId.of("America/New_York");
        ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);
        System.out.println("nyTime = " + nyTime);

        // ZoneOffset - UTC로 부터 얼마만큼 떨어져 있는지
        ZoneOffset krOffset = ZonedDateTime.now().getOffset();
        //ZoneOffset krOffset = ZoneOffset.of("+9");
        System.out.println("krOffset = " + krOffset);
        int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS);
        System.out.println("krOffsetInSec = " + krOffsetInSec);

        // OffsetDateTime - ZoneId가 아닌 ZoneOffset을 사용
        zdt = ZonedDateTime.of(dateTime, zid);
        OffsetDateTime odt = OffsetDateTime.of(dateTime, krOffset);

        // ZoneDateTime -> OffsetDateTime 변환
        odt = zdt.toOffsetDateTime();

        // ZonedDateTime의 변환
        LocalDate date = zdt.toLocalDate();
        LocalTime time = zdt.toLocalTime();
        dateTime = zdt.toLocalDateTime();
    }
}
