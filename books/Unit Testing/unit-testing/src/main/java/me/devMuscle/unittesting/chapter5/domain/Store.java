package me.devMuscle.unittesting.chapter5.domain;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private final Map<Product, Integer> inventory = new HashMap<>();

    public void addInventory(Product product, int amount) {
        inventory.put(product, amount);
    }

    public int getInventory(Product product) {
        return inventory.get(product);
    }

    public boolean hasEnoughInventory(Product product, int amount) {
        return inventory.get(product) >= amount;
    }

    public void removeInventory(Product product, int amount) {
        inventory.replace(product, getInventory(product) - amount);
    }
}
