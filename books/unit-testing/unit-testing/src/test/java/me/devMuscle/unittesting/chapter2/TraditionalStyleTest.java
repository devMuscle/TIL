package me.devMuscle.unittesting.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TraditionalStyleTest {

    @Test
    public void purchase_succeeds_when_enough_inventory() {
        // 준비
        Store store = new Store();
        store.addInventory(Product.SHAMPOO, 10);
        Customer customer = new Customer();

        // 실행
        boolean success = customer.purchase(store, Product.SHAMPOO, 5);

        // 검증
        Assertions.assertTrue(success);
    }

    @Test
    public void purchase_fails_when_not_enough_inventory() {
        // 준비
        Store store = new Store();
        store.addInventory(Product.SHAMPOO, 10);
        Customer customer = new Customer();

        // 실행
        boolean success = customer.purchase(store, Product.SHAMPOO, 15);

        // 검증
        Assertions.assertFalse(success);
        Assertions.assertEquals(10, store.getInventory(Product.SHAMPOO));
    }
}
