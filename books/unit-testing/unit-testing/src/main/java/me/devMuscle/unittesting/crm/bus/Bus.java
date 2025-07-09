package me.devMuscle.unittesting.crm.bus;

public class Bus implements IBus{

    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
