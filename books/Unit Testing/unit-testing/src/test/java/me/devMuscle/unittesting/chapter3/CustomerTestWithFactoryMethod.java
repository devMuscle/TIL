package me.devMuscle.unittesting.chapter3;

import me.devMuscle.unittesting.chapter2.Customer;
import me.devMuscle.unittesting.chapter2.Product;
import me.devMuscle.unittesting.chapter2.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestWithFactoryMethod {

    @Test
    public void purchase_succeeds_when_enough_inventory() {
        Store store = createStoreWithInventory(Product.SHAMPOO, 10);
        Customer sut = createCustomer();

        boolean success = sut.purchase(store, Product.SHAMPOO, 5);

        assertTrue(success);
        assertEquals(5, store.getInventory(Product.SHAMPOO));
    }

    @Test
    public void purchase_fails_when_not_enough_inventory() {
        Store store = createStoreWithInventory(Product.SHAMPOO, 10);
        Customer sut = createCustomer();

        boolean success = sut.purchase(store, Product.SHAMPOO, 15);

        assertFalse(success);
        assertEquals(10, store.getInventory(Product.SHAMPOO));
    }

    private Store createStoreWithInventory(Product product, int quantity) {
        Store store = new Store();
        store.addInventory(product, quantity);
        return store;
    }

    private static Customer createCustomer() {
        return new Customer();
    }
}
