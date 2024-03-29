package me.devMuscle.unittesting.chapter1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCoverageTest {

    public static boolean wasLastStringLong;

    @Test
    public void isStringLong1_테스트_커버리지_80() {
        boolean result = isStringLong1("abc");
        Assertions.assertEquals(false, result);
    }

    @Test
    public void isStringLong2_테스트_커버리지_100() {
        boolean result = isStringLong2("abc");
        Assertions.assertEquals(false, result);
    }

    @Test
    public void 마지막_결과만을_기록하는_경우() {
        boolean result = isStringLong("abc");
        Assertions.assertEquals(false, result); // 두 번째 결과만 검증
    }

    @Test
    public void 검증이_없는_테스트는_언제나_통과한다() {
        boolean result1 = isStringLong("abc");
        boolean result2 = isStringLong("abcdef");
    }

    @Test
    public void 외부_라이브러리의_코드_경로를_고려할_수_없음() {
        int result = parse("5");
        Assertions.assertEquals(5, result);
    }

    public static int parse(String input) {
        return Integer.parseInt(input);
    }

    public static boolean isStringLong(String input) {
        boolean result = input.length() > 5;
        wasLastStringLong = result; //첫 번째 결과
        return result; // 두 번째 결과
    }

    public static boolean isStringLong1(String input) {
        if(input.length() > 5)
            return true;
        return false;
    }

    public static boolean isStringLong2(String input) {
        return input.length() > 5;
    }
}
