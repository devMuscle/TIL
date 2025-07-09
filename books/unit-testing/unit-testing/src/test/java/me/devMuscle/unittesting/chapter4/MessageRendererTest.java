package me.devMuscle.unittesting.chapter4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class MessageRendererTest {

    @Test
    public void messageRenderer_uses_correct_sub_renderers() {
        MessageRenderer sut = new MessageRenderer();

        List<IRenderer> renderers = sut.subRenderers;

        assertEquals(3, renderers.size());
        assertInstanceOf(HeaderRenderer.class, renderers.get(0));
        assertInstanceOf(BodyRenderer.class, renderers.get(1));
        assertInstanceOf(FooterRenderer.class, renderers.get(2));
    }

    @Test
    public void rendering_a_message() {
        MessageRenderer sut = new MessageRenderer();
        Message message = new Message("h", "b", "f");

        String html = sut.render(message);

        assertEquals("<div>h<div><div>b<div><div>f<div>", html);
    }
}