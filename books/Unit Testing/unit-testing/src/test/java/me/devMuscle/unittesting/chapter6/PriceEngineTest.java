package me.devMuscle.unittesting.chapter6;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceEngineTest {

    @Test
    public void discount_of_two_products() {
        Product product1 = new Product("Hand wash");
        Product product2 = new Product("Shampoo");
        PriceEngine sut = new PriceEngine();

        BigDecimal discount = sut.calculateDiscount(new Product[]{product1, product2});

        assertEquals(BigDecimal.valueOf(0.02), discount);
    }
}