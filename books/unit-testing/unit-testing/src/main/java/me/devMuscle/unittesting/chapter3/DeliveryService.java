package me.devMuscle.unittesting.chapter3;

import java.time.LocalDate;

public class DeliveryService {

    public boolean isDeliveryValid(Delivery delivery) {
        LocalDate validDate = LocalDate.now().plusDays(2);

        return (delivery.date.isAfter(validDate) || delivery.date.isEqual(validDate));
    }
}
