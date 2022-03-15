package cm.itrex.service;

import cm.itrex.IntegrationTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingServiceTest extends IntegrationTest {

    @Autowired
    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGreeting() {
        String message = "Hello World 2";
        assertEquals(message, greetingService.greeting());
    }
}
