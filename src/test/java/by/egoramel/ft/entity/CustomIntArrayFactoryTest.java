package by.egoramel.ft.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntArrayFactoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Should create an empty array.")
    void shouldCreateEmptyArray() {
        final CustomIntArray array = CustomIntArrayFactory.createEmptyCustomIntArray();
        final int expect = 0;

        final int actual = array.length();

        assertEquals(expect, actual, "Should be an empty array.");
    }
}