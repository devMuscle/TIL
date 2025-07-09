package me.devMuscle.unittesting.chapter4;

public class BodyRenderer implements IRenderer{

    @Override
    public String render(Message message) {
        return "<div>" + message.body + "<div>";
    }
}
