package me.devMuscle.unittesting.chapter5.controller;

import lombok.AllArgsConstructor;
import me.devMuscle.unittesting.chapter5.EmailGateWay;
import me.devMuscle.unittesting.chapter5.domain.Customer;
import me.devMuscle.unittesting.chapter5.domain.Product;
import me.devMuscle.unittesting.chapter5.domain.Store;
import me.devMuscle.unittesting.chapter5.repository.CustomerRepository;
import me.devMuscle.unittesting.chapter5.repository.ProductRepository;

@AllArgsConstructor
public class CustomerController {

    private EmailGateWay emailGateway;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private Store mainStore;

    public boolean purchase(int customerId, int productId, int quantity) {
        Customer customer = customerRepository.getById(customerId);
        Product product = productRepository.getById(productId);

        boolean isSuccess = customer.purchase(mainStore, product, quantity);

        if(isSuccess) {
            emailGateway.sendReceipt(customer.email, product.name, quantity);
        }

        return isSuccess;
    }
}
