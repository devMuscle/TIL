package ch10.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateAndTimeEx {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        LocalDate birthDate = LocalDate.of(1999, 12,31);
        LocalTime birthTime = LocalTime.of(23,59,59);

        // 일 단위나 초 단위로 지정
        birthDate = LocalDate.ofYearDay(1999,365);
        birthTime = LocalTime.ofSecondOfDay(86399);

        // parse()를 이용하여 문자열을 날짜와 시간으로 변환
        birthDate = LocalDate.parse("1999-12-31");
        birthTime = LocalTime.parse("23:59:59");

        // 특정 필드가 가질 수 잇는 값의 범위
        System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range());

        // 필드의 값 변경하기
        birthDate = birthDate.withYear(2000);
        birthTime = birthTime.withHour(12);

        birthDate = birthDate.plusYears(1);
        birthTime = birthTime.minusHours(1);

        // 시(hour)보다 작은 단위 0으로 변경
        birthTime = birthTime.truncatedTo(ChronoUnit.HOURS);

        // 비교
        LocalDate kDate = LocalDate.of(1999,12,31);
        JapaneseDate jDate = JapaneseDate.of(1999,12,31);

        System.out.println(kDate.equals(jDate));
        System.out.println(kDate.isEqual(jDate));
    }
}
