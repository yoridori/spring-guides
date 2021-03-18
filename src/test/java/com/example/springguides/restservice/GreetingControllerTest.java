package com.example.springguides.restservice;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreetingControllerTest {

    @Test
    public void testGreeting() {
        GreetingController controller = new GreetingController();
        Greeting greeting = controller.greeting("yoridori");
        assertEquals("Hello, yoridori!", greeting.getContent());
        assertEquals(1, greeting.getId());
    }

}
