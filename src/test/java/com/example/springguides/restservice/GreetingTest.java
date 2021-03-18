package com.example.springguides.restservice;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreetingTest {

    Greeting greeting;
    public GreetingTest(){
        greeting = new Greeting(2, "yoridori");
    }
    
    @Test
    public void testGetId() {
        assertEquals(2, greeting.getId());
    }
    
    @Test
    public void testGetContent() {
        assertEquals("yoridori", greeting.getContent());
    }

}
