package me.devMuscle.unittesting.chapter3;

import me.devMuscle.unittesting.chapter2.Customer;
import me.devMuscle.unittesting.chapter2.Product;
import me.devMuscle.unittesting.chapter2.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private Store store;
    private Customer sut;

    public CustomerTest() {
        store = new Store();
        store.addInventory(Product.SHAMPOO, 10);
        sut = new Customer();
    }

    @Test
    public void purchase_succeeds_when_enough_inventory() {
        boolean success = sut.purchase(store, Product.SHAMPOO, 5);

        assertTrue(success);
        assertEquals(5, store.getInventory(Product.SHAMPOO));
    }

    @Test
    public void purchase_fails_when_not_enough_inventory() {
        boolean success = sut.purchase(store, Product.SHAMPOO, 15);

        assertFalse(success);
        assertEquals(10, store.getInventory(Product.SHAMPOO));
    }
}
