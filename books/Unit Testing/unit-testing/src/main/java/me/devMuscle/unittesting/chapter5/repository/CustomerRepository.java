package me.devMuscle.unittesting.chapter5.repository;

import me.devMuscle.unittesting.chapter5.domain.Customer;

public class CustomerRepository {

    public Customer getById(int customerId) {
        return new Customer(customerId, "");
    }
}
