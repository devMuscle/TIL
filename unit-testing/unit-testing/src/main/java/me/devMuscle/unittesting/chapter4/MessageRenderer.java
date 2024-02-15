package me.devMuscle.unittesting.chapter4;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MessageRenderer implements IRenderer{

    public List<IRenderer> subRenderers;

    public MessageRenderer() {
        subRenderers = new ArrayList<>() {{
            add(new HeaderRenderer());
            add(new BodyRenderer());
            add(new FooterRenderer());
        }};
    }

    @Override
    public String render(Message message) {
        return subRenderers.stream()
                .map(x -> x.render(message))
                .collect(Collectors.joining());
    }
}
