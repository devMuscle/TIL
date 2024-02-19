package me.devMuscle.unittesting.chapter7;

public class MessageBus {

    private MessageBus() {}

    private static class MessageBusInstanceHandler {
        private static final MessageBus INSTANCE = new MessageBus();
    }

    public static MessageBus getInstance() {
        return MessageBusInstanceHandler.INSTANCE;
    }

    public void sendEmailChangedMessage(int userId, String newEmail) {}
}
