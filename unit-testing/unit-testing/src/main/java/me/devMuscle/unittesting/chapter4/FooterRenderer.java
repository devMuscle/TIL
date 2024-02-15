package me.devMuscle.unittesting.chapter4;

public class FooterRenderer implements IRenderer{

    @Override
    public String render(Message message) {
        return "<div>" +  message.footer + "<div>";
    }
}
