package by.egoramel.ft.factory.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.factory.CustomIntArrayFactory;
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
    @DisplayName("Should create array with size 5.")
    void shouldCreateArrayWithSize() throws CustomIntArrayException {
        final CustomIntArray array = customIntArrayFactory.createWithSizeCustomIntArray(5, 1L);
        final int expect = 5;

        final int actual = array.length();

        assertEquals(expect, actual, "Should be an empty array.");
    }
}