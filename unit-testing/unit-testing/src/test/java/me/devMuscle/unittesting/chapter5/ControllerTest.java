package me.devMuscle.unittesting.chapter5;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ControllerTest {

    @Test
    public void sending_a_greetings_email() {
        EmailGateWay emailGateWay = mock(EmailGateWay.class);
        Controller sut = new Controller(emailGateWay);

        sut.greetUser("user@email.com");

        verify(emailGateWay, times(1)).sendGreetingEmail("user@email.com");
    }
}