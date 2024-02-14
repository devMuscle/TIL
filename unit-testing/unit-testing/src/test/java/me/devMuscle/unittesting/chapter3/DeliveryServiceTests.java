package me.devMuscle.unittesting.chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryServiceTests {

    @ParameterizedTest
    @CsvSource({"-1, false", "0, false", "1, false", "2, true"})
    public void can_detect_an_invalid_delivery_date(int daysFromNow, boolean expected) {
        DeliveryService sut = new DeliveryService();
        LocalDate deliveryDate = LocalDate.now().plusDays(daysFromNow);
        Delivery delivery = new Delivery(deliveryDate);

        boolean isValid = sut.isDeliveryValid(delivery);

        assertEquals(expected, isValid);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public void detects_an_invalid_delivery_date(int daysFromNow) {
        DeliveryService sut = new DeliveryService();
        LocalDate deliveryDate = LocalDate.now().plusDays(daysFromNow);
        Delivery delivery = new Delivery(deliveryDate);

        boolean isValid = sut.isDeliveryValid(delivery);

        assertFalse(isValid);
    }

    @Test
    public void the_soonest_delivery_date_is_two_days_from_now() {
        DeliveryService sut = new DeliveryService();
        LocalDate deliveryDate = LocalDate.now().plusDays(2);
        Delivery delivery = new Delivery(deliveryDate);

        boolean isValid = sut.isDeliveryValid(delivery);

        assertTrue(isValid);
    }
}
