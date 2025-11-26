package by.egoramel.ft.validator.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.validator.CustomIntArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class CustomIntArrayValidatorImpl implements CustomIntArrayValidator {
    private static final Logger LOGGER = LogManager.getLogger(CustomIntArrayValidatorImpl.class);
    private final static int NEGATIVE_SIZE = 0;

    public void validationOnNegativeSize(final int size) {
        LOGGER.debug("Validating array size: {}", size);

        if (size < NEGATIVE_SIZE) {
            LOGGER.error("Attempt to create an array with negative size: {}", size);
            throw new CustomIntArrayException("Attempt to create an array with negative size.");
        }
        LOGGER.debug("Array size validation passed");
    }

    public void validateStringList(final List<String> stringList) {
        LOGGER.debug("Validating a string list.");

        if (stringList == null || stringList.isEmpty()) {
            LOGGER.error("File is empty or null.");
            throw new CustomIntArrayException("File is empty or null.");
        }
        LOGGER.debug("String list validation passed.");
    }

    public void validateCustomIntArray(final CustomIntArray customIntArray, final String message) {
        LOGGER.debug("Validating a customIntArray array.");

        if (customIntArray == null) {
            LOGGER.error("{} - customIntArray is null", message);
            throw new CustomIntArrayException("customIntArray is null.");
        }

        if (customIntArray.length() == 0) {
            LOGGER.error("{} - customIntArray is empty", message);
            throw new CustomIntArrayException("customIntArray is empty.");
        }
    }

    public void validateArray(final int[] array) {
        LOGGER.debug("Validating an array.");

        if (array == null) {
            LOGGER.error("Array is null.");
            throw new CustomIntArrayException("Array is null.");
        }

        if (array.length == 0) {
            LOGGER.error("Array is empty.");
            throw new CustomIntArrayException("Array is empty.");
        }
    }

    public void validateBounds(final int index, final int arrayLength) {
        LOGGER.debug("Validating an array bounds.");
        if (index >= arrayLength || index < NEGATIVE_SIZE) {
            LOGGER.error("Index out of bound: {}", index);
            throw new CustomIntArrayException("Index out of bound: " + index);
        }
    }
}