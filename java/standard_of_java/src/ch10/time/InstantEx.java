package ch10.time;

import java.time.Instant;
import java.util.Date;

public class InstantEx {

    public static void main(String[] args) {
        // 생성
        Instant now = Instant.now();
        Instant now2 = Instant.ofEpochSecond(now.getEpochSecond());
        Instant now3 = Instant.ofEpochSecond(now.getEpochSecond(), now.getNano());

        System.out.println("now = " + now);
        System.out.println("now2 = " + now2);
        System.out.println("now3 = " + now3);

        // 필드 가져오기
        long epochSec = now.getEpochSecond();
        int nano = now.getNano();

        System.out.println("epochSec = " + epochSec);
        System.out.println("nano = " + nano);

        // Instant와 Date간의 변환
        Date now4 = Date.from(now);
        Instant now5 = now4.toInstant();

        System.out.println("now4 = " + now4);
        System.out.println("now5 = " + now5);
    }
}
