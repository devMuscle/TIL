package me.devMuscle.unittesting.chapter5.repository;

import me.devMuscle.unittesting.chapter5.domain.Product;

public class ProductRepository {

    public Product getById(int productId) {
        return new Product(productId, "");
    }
}
