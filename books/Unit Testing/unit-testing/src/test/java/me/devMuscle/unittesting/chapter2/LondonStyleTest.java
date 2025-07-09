package me.devMuscle.unittesting.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LondonStyleTest {

    @Mock
    Store storeMock;

    @Test
    public void purchase_succeeds_when_enough_inventory() {
        // 준비
        when(storeMock.hasEnoughInventory(Product.SHAMPOO, 5)).thenReturn(true);
        Customer customer = new Customer();

        // 실행
        boolean success = customer.purchase(storeMock, Product.SHAMPOO, 5);

        // 검증
        Assertions.assertTrue(success);
        verify(storeMock, times(1)).removeInventory(Product.SHAMPOO, 5);
    }

    @Test
    public void purchase_fails_when_not_enough_inventory() {
        // 준비
        when(storeMock.hasEnoughInventory(Product.SHAMPOO, 5)).thenReturn(false);
        Customer customer = new Customer();

        // 실행
        boolean success = customer.purchase(storeMock, Product.SHAMPOO, 5);

        // 검증
        Assertions.assertFalse(success);
        verify(storeMock, times(0)).removeInventory(Product.SHAMPOO, 5);
    }
}
