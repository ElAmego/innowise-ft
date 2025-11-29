package by.egoramel.ft.service.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.service.CustomIntArraySort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CustomIntArraySortImpl implements CustomIntArraySort {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public CustomIntArray bubbleSort(final CustomIntArray customIntArray) throws CustomIntArrayException {
        LOGGER.debug("Starting bubble sort on array");

        for (int i = 0; i < customIntArray.length(); i++) {
            LOGGER.debug("Bubble sort outer iteration: {}", i);
            for (int j = 0; j < customIntArray.length() - i - 1 ; j++) {
                LOGGER.trace("Comparing elements at indices {} and {}: ", i,  j + 1);
                final int nextValue = customIntArray.get(j + 1);
                if (customIntArray.get(j) > nextValue) {
                    int temp = customIntArray.get(j);
                    customIntArray.set(j, nextValue);
                    customIntArray.set(j + 1, temp);
                    LOGGER.trace("Swapped elements at indices {} and {}", j, j + 1);
                }
            }
        }

        LOGGER.info("Bubble sort completed.");
        return customIntArray;
    }

    @Override
    public CustomIntArray selectionSort(final CustomIntArray customIntArray) throws CustomIntArrayException {
        LOGGER.debug("Starting selection sort on array");

        for (int i = 0; i < customIntArray.length() - 1; i++) {
            LOGGER.debug("Selection sort outer iteration: {}", i);
            int minIndex = i;
            for (int j = i + 1; j < customIntArray.length(); j++) {
                LOGGER.trace("Comparing candidate at index {} with current min at index {}: ", j, minIndex);
                if (customIntArray.get(j) < customIntArray.get(minIndex)) {
                    minIndex = j;
                    LOGGER.trace("New min index found: {}", minIndex);
                }
            }

            if (minIndex != i) {
                int temp = customIntArray.get(i);
                int minValue = customIntArray.get(minIndex);
                customIntArray.set(i, minValue);
                customIntArray.set(minIndex, temp);
                LOGGER.debug("Swapped elements at indices {} and {}", i, minIndex);
            }
        }
        LOGGER.info("Selection sort completed.");
        return customIntArray;
    }
}