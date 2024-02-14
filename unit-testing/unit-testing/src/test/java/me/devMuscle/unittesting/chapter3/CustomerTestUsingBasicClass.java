package me.devMuscle.unittesting.chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerTestUsingBasicClass extends IntegrationTest{

    @Test
    public void purchase_succeeds_when_enough_inventory() {
        assertNotNull(database);
    }
}
