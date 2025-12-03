package by.egoramel.ft.service.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.factory.CustomIntArrayFactory;
import by.egoramel.ft.factory.impl.CustomIntArrayFactoryImpl;
import by.egoramel.ft.service.CustomIntArrayCalculation;
import by.egoramel.ft.service.CustomIntArraySort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CustomIntArrayCalculationImplTest {
    private CustomIntArrayCalculation customIntArrayCalculation;
    private CustomIntArraySort customIntArraySort;
    private CustomIntArrayFactory customIntArrayFactory;

    @BeforeEach
    void setUp() {
        customIntArrayCalculation = new CustomIntArrayCalculationImpl();
        customIntArraySort = new CustomIntArraySortImpl();
        customIntArrayFactory = new CustomIntArrayFactoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Should correctly calculate a max value for an array.")
    void checkMax() throws CustomIntArrayException {
        final int[] testData = {4, 2, -5, 6, 0, 100, -10};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(testData, 1L);
        final int expect = 100;

        final int actual = customIntArrayCalculation.findMax(array);

        assertEquals(expect, actual, "Max value should be 100");
    }

    @Test
    @DisplayName("Should correctly calculate a min value for an array.")
    void checkMin() throws CustomIntArrayException {
        final int[] testData = {5, 6, 0, -99, -10};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(testData, 2L);
        final int expect = -99;

        final int actual = customIntArrayCalculation.findMin(array);

        assertEquals(expect, actual, "Min value should be -99");
    }

    @Test
    @DisplayName("Should correctly calculate a min value for an array.")
    void checkSum() throws CustomIntArrayException {
        final int[] testData = {-100, 100, 500, 0, 333, -332};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(testData, 3L);
        final int expect = 501;

        final int actual = customIntArrayCalculation.calculateSum(array);

        assertEquals(expect, actual, "Sum should be 501");
    }

    @Test
    @DisplayName("Should correctly sort an array by Bubble sort.")
    void checkBubbleSort() throws CustomIntArrayException {
        final int[] testData = {-2, 5, -10, 22, 13};
        final int[] expect = {-10, -2, 5, 13, 22};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(testData, 4L);
        final String expectResult = Arrays.toString(expect);

        final CustomIntArray sortedCustomIntArray = customIntArraySort.bubbleSort(array);
        final int[] sortedArray = sortedCustomIntArray.getArray();
        final String result = Arrays.toString(sortedArray);

        assertEquals(expectResult, result, "Correct sort: [-10, -2, 5, 13, 22]");
    }

    @Test
    @DisplayName("Should correctly sort an array by Selection sort.")
    void checkSelectionSort() throws CustomIntArrayException {
        final int[] testData = {23, -5, 0, 11, 6};
        final int[] expect = {-5, 0, 6, 11, 23};
        final CustomIntArray array = customIntArrayFactory.createFromArrayCustomIntArray(testData, 5L);
        final String expectResult = Arrays.toString(expect);

        final CustomIntArray sortedCustomIntArray = customIntArraySort.bubbleSort(array);
        final int[] sortedArray = sortedCustomIntArray.getArray();
        final String result = Arrays.toString(sortedArray);

        assertEquals(expectResult, result, "Correct sort: [-5, 0, 6, 11, 23]");
    }
}