package me.devMuscle.unittesting.chapter5.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Customer {

    private int id;
    public String email;

    public boolean purchase(Store store, Product product, int amount) {
        if(store.hasEnoughInventory(product, amount)) {
            store.removeInventory(product, amount);

            return true;
        }

        return false;
    }

}
