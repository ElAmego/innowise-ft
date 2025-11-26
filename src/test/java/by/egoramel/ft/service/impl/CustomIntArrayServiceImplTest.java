package by.egoramel.ft.service.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.factory.impl.CustomIntArrayFactoryImpl;
import by.egoramel.ft.service.CustomIntArrayService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntArrayServiceImplTest {
    private CustomIntArrayService customIntArrayService;
    private CustomIntArrayFactory customIntArrayFactory;

    @BeforeEach
    void setUp() {
        customIntArrayService = new CustomIntArrayServiceImpl();
        customIntArrayFactory = new CustomIntArrayFactoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Should correctly calculate a max value for an array.")
    void checkMax() {
        final int[] testData = {4, 2, -5, 6, 0, 100, -10};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(testData);
        final int expect = 100;

        final int actual = customIntArrayService.getMax(array);

        assertEquals(expect, actual, "Max value should be 100");
    }

    @Test
    @DisplayName("Should correctly calculate a min value for an array.")
    void checkMin() {
        final int[] testData = {5, 6, 0, -99, -10};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(testData);
        final int expect = -99;

        final int actual = customIntArrayService.getMin(array);

        assertEquals(expect, actual, "Min value should be -99");
    }

    @Test
    @DisplayName("Should correctly calculate a min value for an array.")
    void checkSum() {
        final int[] testData = {-100, 100, 500, 0, 333, -332};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(testData);
        final int expect = 501;

        final int actual = customIntArrayService.getSum(array);

        assertEquals(expect, actual, "Sum should be 501");
    }

    @Test
    @DisplayName("Should correctly sort an array by Bubble sort.")
    void checkBubbleSort() {
        final int[] testData = {-2, 5, -10, 22, 13};
        final int[] expect = {-10, -2, 5, 13, 22};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(testData);
        final CustomIntArray expectArray = customIntArrayFactory.createFromArrayCustomIntArray(expect);

        final CustomIntArray actual = customIntArrayService.bubbleSort(array);

        assertEquals(expectArray, actual, "Correct sort: [-10, -2, 5, 13, 22]");
    }

    @Test
    @DisplayName("Should correctly sort an array by Selection sort sort.")
    void checkSelectionSort() {
        final int[] testData = {23, -5, 0, 11, 6};
        final int[] expect = {-5, 0, 6, 11, 23};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(testData);
        final CustomIntArray expectArray = customIntArrayFactory.createFromArrayCustomIntArray(expect);

        final CustomIntArray actual = customIntArrayService.selectionSort(array);

        assertEquals(expectArray, actual, "Correct sort: [-5, 0, 6, 11, 23]");
    }
}