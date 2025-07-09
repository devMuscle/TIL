package me.devMuscle.unittesting.chapter6;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Order {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }
}
