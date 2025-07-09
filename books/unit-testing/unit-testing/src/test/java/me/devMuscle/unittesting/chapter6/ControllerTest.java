package me.devMuscle.unittesting.chapter6;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void sending_a_greetings_email() {
        EmailGateWay emailGateWayMock = mock(EmailGateWay.class);
        Controller sut = new Controller(emailGateWayMock);

        sut.greetUser("user@email.com");

        verify(emailGateWayMock, times(1))
                                .sendGreetingEmail("user@email.com");
    }
}
