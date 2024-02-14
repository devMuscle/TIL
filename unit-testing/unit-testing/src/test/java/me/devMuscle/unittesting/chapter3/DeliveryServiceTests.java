package me.devMuscle.unittesting.chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class DeliveryServiceTests {

    @ParameterizedTest
    @CsvSource({"-1, false", "0, false", "1, false", "2, true"})
    public void can_detect_an_invalid_delivery_date(int daysFromNow, boolean expected) {
        DeliveryService sut = new DeliveryService();
        LocalDate deliveryDate = LocalDate.now().plusDays(daysFromNow);
        Delivery delivery = new Delivery(deliveryDate);

        boolean isValid = sut.isDeliveryValid(delivery);

        Assertions.assertEquals(expected, isValid);
    }
}
