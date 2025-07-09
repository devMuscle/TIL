package me.devMuscle.unittesting.chapter4;

public class HeaderRenderer implements IRenderer{

    @Override
    public String render(Message message) {
        return "<div>" + message.header + "<div>";
    }
}
