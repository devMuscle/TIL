package me.devMuscle.unittesting.chapter7;

public class Bus implements IBus{

    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
