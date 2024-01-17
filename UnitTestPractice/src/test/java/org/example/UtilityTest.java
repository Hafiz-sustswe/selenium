package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void testAdd() {
        assertEquals(10, Utility.add(7, 3), "7 + 3 should equal 10");
    }

    @Test
    void testIsEven() {
        assertFalse(Utility.isEven(5), "5 should not be even");
        assertTrue(Utility.isEven(4), "4 should be even");
    }

    @Test
    void testGetGreeting() {
        String name = "John";
        assertNotNull(Utility.getGreeting(name), "Greeting should not be null for a non-null name");

        String nullName = null;
        assertNull(Utility.getGreeting(nullName), "Greeting should be null for a null name");
    }
}