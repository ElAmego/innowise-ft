package by.egoramel.ft.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

@SuppressWarnings("unused")
public final class CustomIntArrayFactory {
    private static final int EMPTY_ARRAY_SIZE = 0;
    private static final Logger LOGGER = LogManager.getLogger(CustomIntArrayFactory.class);

    private CustomIntArrayFactory() {}

    public static CustomIntArray createEmptyCustomIntArray() {
        LOGGER.debug("Attempt to create empty CustomIntArray.");
        return new CustomIntArray(EMPTY_ARRAY_SIZE);
    }

    public static CustomIntArray createWithSizeCustomIntArray(final int size) {
        LOGGER.debug("Attempt to create CustomIntArray with size {}.", size);
        return new CustomIntArray(size);
    }

    public static CustomIntArray createFromArrayCustomIntArray(final int[] initialArray) {
        LOGGER.debug("Attempt to create CustomIntArray from {}.", Arrays.toString(initialArray));
        return new CustomIntArray(initialArray);
    }
}