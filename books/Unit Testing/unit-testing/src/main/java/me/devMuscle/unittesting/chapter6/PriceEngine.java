package me.devMuscle.unittesting.chapter6;

import java.math.BigDecimal;

public class PriceEngine {

    public BigDecimal calculateDiscount(Product[] products) {
        BigDecimal discount = BigDecimal.valueOf(0.01).multiply(BigDecimal.valueOf(products.length));

        return discount.compareTo(BigDecimal.valueOf(0.2)) < 0 ? discount : BigDecimal.valueOf(0.2);
    }
}
