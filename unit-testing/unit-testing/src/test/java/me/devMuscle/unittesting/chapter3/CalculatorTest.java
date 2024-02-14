package me.devMuscle.unittesting.chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    public void sum_of_two_numbers() {
        // 준비
        double first = 10;
        double second = 20;
        //Calculator calculator = new Calculator();
        Calculator sut = new Calculator();

        // 실행
        //double result = calculator.sum(first, second);
        double result = sut.sum(first, second);

        // 검증
        assertEquals(30, result);
    }
}