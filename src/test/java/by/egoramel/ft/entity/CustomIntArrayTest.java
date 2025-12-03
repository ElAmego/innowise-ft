package by.egoramel.ft.entity;

import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.factory.impl.CustomIntArrayFactoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntArrayTest {
    private CustomIntArrayFactory customIntArrayFactory;

    @BeforeEach
    void setUp() {
        customIntArrayFactory = new CustomIntArrayFactoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Should correctly set a value by the definite index.")
    void shouldSetCorrectValue() throws CustomIntArrayException {
        final CustomIntArray array = customIntArrayFactory.createWithSizeCustomIntArray(5, 1L);
        final int expect = 501;
        final int index = 2;

        array.set(index, expect);
        final int actual = array.get(2);

        assertEquals(expect, actual, "The value should be equal 501.");
    }

    @Test
    @DisplayName("Should correctly get a value by the definite index.")
    void shouldGetCorrectValue() throws CustomIntArrayException {
        final int[] initialArray = {22, 19, 0};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(initialArray, 2L);
        final int expect = 22;

        final int actual = array.get(0);

        assertEquals(expect, actual, "The value should be equal 22.");
    }

    @Test
    @DisplayName("Should correctly get a length of the array.")
    void shouldGetCorrectLength() throws CustomIntArrayException {
        final int[] initialArray = {-5, 1};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(initialArray, 3L);
        final int expect = 2;

        final int actual = array.length();

        assertEquals(expect, actual, "The length should be equal 2.");
    }
}