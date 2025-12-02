package by.egoramel.ft.validator.impl;

import by.egoramel.ft.validator.CustomIntArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CustomIntArrayValidatorImpl implements CustomIntArrayValidator {
    private static final Logger LOGGER = LogManager.getLogger();

    public boolean minimumSizeValidation(final int size) {
        LOGGER.debug("Minimum size validation.");
        final int minSize = 0;

        if (size < minSize) {
            LOGGER.error("Attempt to create an array with size < 0: {}", size);
            return false;
        }

        LOGGER.debug("Minimum size validation passed.");
        return true;
    }

    public boolean initialArrayValidation(final int[] array) {
        LOGGER.debug("Initial array validation.");

        if (array == null) {
            LOGGER.error("Array is null.");
            return false;
        }

        if (array.length == 0) {
            LOGGER.error("Array is empty.");
            return false;
        }

        LOGGER.debug("Initial array validation passed.");
        return true;
    }
}