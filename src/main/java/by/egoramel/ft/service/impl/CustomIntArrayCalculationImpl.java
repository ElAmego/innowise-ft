package by.egoramel.ft.service.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.service.CustomIntArrayCalculation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CustomIntArrayCalculationImpl implements CustomIntArrayCalculation {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int defaultValue = 0;

    @Override
    public int findMin(final CustomIntArray customIntArray) {
        LOGGER.debug("Attempt to find minimum value in customIntArray.");

        try {
            int min = customIntArray.get(0);

            for (int i = 1; i < customIntArray.length(); i++) {
                int value = customIntArray.get(i);
                LOGGER.trace("Comparing min: {} with value: {} at index: {}", min, value, i);

                if (min > value) {
                    min = value;
                    LOGGER.trace("New min value found: {} at index: {}", min, i);
                }
            }

            LOGGER.info("Minimum value found: {}", min);

            return min;
        } catch (final CustomIntArrayException e) {
            LOGGER.error("Error in findMin.");
            return defaultValue;
        }
    }

    @Override
    public int findMax(final CustomIntArray customIntArray) {
        LOGGER.debug("Attempt to find maximum value in customIntArray.");

        try {
            int max = customIntArray.get(0);

            for (int i = 1; i < customIntArray.length(); i++) {
                int value = customIntArray.get(i);
                LOGGER.trace("Comparing max: {} with value: {} at index: {}", max, value, i);

                if (max < value) {
                    max = value;
                    LOGGER.trace("New max value found: {} at index: {}", max, i);
                }
            }

            LOGGER.info("Maximum value found: {}", max);

            return max;
        } catch (final CustomIntArrayException e) {
            LOGGER.error("Error in findMax.");
            return defaultValue;
        }
    }

    @Override
    public int calculateSum(final CustomIntArray customIntArray) {
        LOGGER.debug("Attempt to calculate sum of customIntArray.");

        try {
            int sum = 0;
            for (int i = 0; i < customIntArray.length(); i++) {
                int value = customIntArray.get(i);
                sum += value;
                LOGGER.trace("Added value: {} at index: {}, current sum: {}", value, i, sum);
            }

            LOGGER.info("Sum calculated: {} for array size: {}", sum, customIntArray.length());

            return sum;
        } catch (final CustomIntArrayException e) {
            LOGGER.error("Error in findSum.");
            return defaultValue;
        }
    }

    @Override
    public int calculateAvg(final CustomIntArray customIntArray) {
        LOGGER.debug("Attempt to calculate avg of an customIntArray.");

        final int customIntArraySum = calculateSum(customIntArray);

        if (customIntArraySum != defaultValue) {
            final int customIntArraySize = customIntArray.length();
            final int avg = customIntArraySum / customIntArraySize;

            LOGGER.info("Avg calculated: {} for array size: {}", avg, customIntArray.length());

            return avg;
        } else {
            LOGGER.debug("CustomIntArraySum is empty.");
            return 0;
        }
    }
}