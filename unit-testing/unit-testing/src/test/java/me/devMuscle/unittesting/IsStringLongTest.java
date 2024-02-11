package me.devMuscle.unittesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsStringLongTest {

    @Test
    public void isStringLong1Test() {
        boolean result = isStringLong1("abc");
        Assertions.assertEquals(false, result);
    }

    @Test
    public void isStringLong2Test() {
        boolean result = isStringLong2("abc");
        Assertions.assertEquals(false, result);
    }

    public static boolean isStringLong1(String input) {
        if(input.length() > 5)  {
            return true;
        }
        return false;
    }

    public static boolean isStringLong2(String input) {
        return input.length() > 5;
    }
}
