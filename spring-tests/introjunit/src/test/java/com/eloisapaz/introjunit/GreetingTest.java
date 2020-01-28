package com.eloisapaz.introjunit;

import org.junit.jupiter.api.*;

class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before - call once");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before each...");
        greeting = new Greeting();
    }

    @Test
    void testHelloWorld1() {
        System.out.println(greeting.helloWorld());
    }

    @Test
    void testHelloWorld2() {
        System.out.println(greeting.helloWorld("Lolla"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each...");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("After - call once");
    }

}