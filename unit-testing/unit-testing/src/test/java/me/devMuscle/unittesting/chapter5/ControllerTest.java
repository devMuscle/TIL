package me.devMuscle.unittesting.chapter5;

import me.devMuscle.unittesting.chapter5.Database;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ControllerTest {

    @Test
    public void sending_a_greetings_email() {
        EmailGateWay emailGateWay = mock(EmailGateWay.class);
        Controller sut = new Controller(emailGateWay);

        sut.greetUser("user@email.com");

        verify(emailGateWay, times(1)).sendGreetingEmail("user@email.com");
    }

    @Test
    public void creating_a_report() {
        Database stub = mock(Database.class);
        when(stub.getNumberOfUsers()).thenReturn(10);
        Controller sut = new Controller(stub);

        Report report = sut.createReport();

        assertEquals(10, report.numberOfUsers);
    }

    @Test
    public void creating_a_report_easy_broken() {
        Database stub = mock(Database.class);
        when(stub.getNumberOfUsers()).thenReturn(10);
        Controller sut = new Controller(stub);

        Report report = sut.createReport();

        assertEquals(10, report.numberOfUsers);
        verify(stub, times(1)).getNumberOfUsers();
    }
}