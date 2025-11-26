package by.egoramel.ft.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntArrayTest {
    private CustomIntArrayFactory customIntArrayFactory;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Should correctly set a value by the definite index.")
    void setValue() {
        final CustomIntArray array = CustomIntArrayFactory.createWithSizeCustomIntArray(5);
        final int expect = 501;
        final int index = 2;

        array.set(index, expect);
        final int actual = array.get(2);

        assertEquals(expect, actual, "The value should be equal 5.");
    }

    @Test
    @DisplayName("Should correctly get a value by the definite index.")
    void getValue() {
        final int[] initialArray = {22, 19, 0};
        final CustomIntArray array = CustomIntArrayFactory.createFromArrayCustomIntArray(initialArray);
        final int expect = 22;

        final int actual = array.get(0);

        assertEquals(expect, actual, "The value should be equal 22.");
    }

    @Test
    @DisplayName("Should correctly get a length of the array.")
    void getLength() {
        final int[] initialArray = {-5, 1};
        final CustomIntArray array = CustomIntArrayFactory.createFromArrayCustomIntArray(initialArray);
        final int expect = 2;

        final int actual = array.length();

        assertEquals(expect, actual, "The length should be equal 2.");
    }
}