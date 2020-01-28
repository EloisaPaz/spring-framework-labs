package com.eloisapaz.introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    @Test
    void testHelloWorld1() {
        Greeting greeting = new Greeting();
        System.out.println(greeting.helloWorld());
    }

    @Test
    void testHelloWorld2() {
        Greeting greeting = new Greeting();
        System.out.println(greeting.helloWorld("Lolla"));
    }
}