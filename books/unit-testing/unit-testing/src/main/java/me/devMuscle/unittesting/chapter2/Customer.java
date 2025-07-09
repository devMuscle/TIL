package me.devMuscle.unittesting.chapter2;

public class Customer {

    public boolean purchase(Store store, Product product, int amount) {
        if(store.hasEnoughInventory(product, amount)) {
            store.removeInventory(product, amount);

            return true;
        }

        return false;
    }
}
