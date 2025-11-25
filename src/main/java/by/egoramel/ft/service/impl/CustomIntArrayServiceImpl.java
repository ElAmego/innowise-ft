package by.egoramel.ft.service.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.service.CustomIntArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CustomIntArrayServiceImpl implements CustomIntArrayService {
    private final Logger logger = LogManager.getLogger(CustomIntArrayServiceImpl.class);
    private final String getMinErrorMessage = "Failed to find minimum";
    private final String getMaxErrorMessage = "Failed to find maximum";
    private final String getSumErrorMessage = "Failed to find sum";
    private final String sortErrorMessage = "Failed to sort an array";

    @Override
    public int getMin(final CustomIntArray customIntArray) {
        logger.debug("Attempt to find minimum value in array");

        validateArray(customIntArray, getMinErrorMessage);

        logger.debug("Starting minimum search in array of size: {}", customIntArray.length());
        int min = customIntArray.get(0);

        for (int i = 1; i < customIntArray.length(); i++) {
            int value = customIntArray.get(i);
            logger.trace("Comparing min: {} with value: {} at index: {}", min, value, i);

            if (min > value) {
                min = value;
                logger.trace("New min value found: {} at index: {}", min, i);
            }
        }

        logger.info("Minimum value found: {}", min);
        return min;
    }

    @Override
    public int getMax(final CustomIntArray customIntArray) {
        logger.debug("Attempt to find maximum value in array");

        validateArray(customIntArray, getMaxErrorMessage);

        logger.debug("Starting maximum search in array of size: {}", customIntArray.length());
        int max = customIntArray.get(0);
        logger.trace("Initial max value: {}", max);

        for (int i = 1; i < customIntArray.length(); i++) {
            int value = customIntArray.get(i);
            logger.trace("Comparing max: {} with value: {} at index: {}", max, value, i);

            if (max < value) {
                max = value;
                logger.trace("New max value found: {} at index: {}", max, i);
            }
        }

        logger.info("Maximum value found: {}", max);
        return max;
    }

    @Override
    public int getSum(final CustomIntArray customIntArray) {
        logger.debug("Attempt to get the sum of array values.");

        validateArray(customIntArray, getSumErrorMessage);

        int sum = 0;
        for (int i = 0; i < customIntArray.length(); i++) {
            int value = customIntArray.get(i);
            sum += value;
            logger.trace("Added value: {} at index: {}, current sum: {}", value, i, sum);
        }

        logger.info("Sum calculated: {} for array size: {}", sum, customIntArray.length());
        return sum;
    }

    @Override
    public CustomIntArray bubbleSort(final CustomIntArray customIntArray) {
        logger.debug("Starting bubble sort on array");

        validateArray(customIntArray, sortErrorMessage);

        logger.debug("Bubble sort started on array of size: {}", customIntArray.length());

        for (int i = 0; i < customIntArray.length(); i++) {
            logger.debug("Bubble sort outer iteration: {}", i);
            for (int j = 0; j < customIntArray.length() - i - 1 ; j++) {
                logger.trace("Comparing elements at indices {} and {}: ", i,  j + 1);
                if (customIntArray.get(j) > customIntArray.get(j + 1)) {
                    int temp = customIntArray.get(j);
                    customIntArray.set(j, customIntArray.get(j + 1));
                    customIntArray.set(j + 1, temp);
                    logger.trace("Swapped elements at indices {} and {}", i, j + 1);
                }
            }
        }

        logger.info("Bubble sort completed.");
        return customIntArray;
    }

    @Override
    public CustomIntArray selectionSort(final CustomIntArray customIntArray) {
        logger.debug("Starting selection sort on array");

        validateArray(customIntArray, sortErrorMessage);

        logger.debug("Selection sort started on array of size: {}", customIntArray.length());

        for (int i = 0; i < customIntArray.length() - 1; i++) {
            logger.debug("Selection sort outer iteration: {}", i);
            int minIndex = i;
            for (int j = i + 1; j < customIntArray.length(); j++) {
                logger.trace("Comparing candidate at index {} with current min at index {}: ", j, minIndex);
                if (customIntArray.get(j) < customIntArray.get(minIndex)) {
                    minIndex = j;
                    logger.trace("New min index found: {}", minIndex);
                }
            }

            if (minIndex != i) {
                int temp = customIntArray.get(i);
                customIntArray.set(i, customIntArray.get(minIndex));
                customIntArray.set(minIndex, temp);
                logger.debug("Swapped elements at indices {} and {}", i, minIndex);
            }
        }
        logger.info("Selection sort completed.");
        return customIntArray;
    }

    private void validateArray(final CustomIntArray customIntArray, final String message) {
        if (customIntArray == null) {
            logger.error("{} - array is null", message);
            throw new CustomIntArrayException("Array is null.");
        }

        if (customIntArray.length() == 0) {
            logger.error("{} - array is empty", message);
            throw new CustomIntArrayException("Array is empty.");
        }
    }
}