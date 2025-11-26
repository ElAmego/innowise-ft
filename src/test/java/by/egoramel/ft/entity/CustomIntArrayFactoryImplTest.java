package by.egoramel.ft.entity;

import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.factory.impl.CustomIntArrayFactoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntArrayFactoryImplTest {
    private CustomIntArrayFactory customIntArrayFactory;

    @BeforeEach
    void setUp() {
        customIntArrayFactory = new CustomIntArrayFactoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Should create an empty array.")
    void shouldCreateEmptyArray() {
        final CustomIntArray array = customIntArrayFactory.createEmptyCustomIntArray();
        final int expect = 0;

        final int actual = array.length();

        assertEquals(expect, actual, "Should be an empty array.");
    }
}