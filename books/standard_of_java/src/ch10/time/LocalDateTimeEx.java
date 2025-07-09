package ch10.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeEx {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        
        // LocalDate, LocalTime을 이용하여 LocalDateTime 생성
        LocalDateTime now = LocalDateTime.of(date, time);
        now = date.atTime(time);
        now = time.atDate(date);
        now = date.atTime(8,49,12);
        now = time.atDate(LocalDate.of(2024,03,01));
        now = date.atStartOfDay(); // 0시 0분 0초
        
        // LocalDateTime 자체 제공 메서드
        now = LocalDateTime.of(2024,03,01,20,49,12);
        now = LocalDateTime.now();

        // LocalDateTime 변환
        date = now.toLocalDate();
        time = now.toLocalTime();
    }
}
