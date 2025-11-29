package by.egoramel.ft.entity;

import by.egoramel.ft.exception.CustomIntArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.StringJoiner;

@SuppressWarnings("unused")
public class CustomIntArray {
    private static final Logger LOGGER = LogManager.getLogger();
    private final int[] array;

    public CustomIntArray(final int size) {
        LOGGER.info("Successful CustomIntArray creation with size: {}", size);
        this.array = new int[size];
    }

    public CustomIntArray(final int[] initialArray) {
        LOGGER.info("Successful CustomIntArray creation from array: {}", Arrays.toString(initialArray));
        this.array = Arrays.copyOf(initialArray, initialArray.length);
    }

    public int get(final int index) throws CustomIntArrayException {
        final boolean isValid = boundsValidator(index, array.length);

        if (!isValid) {
            throw new CustomIntArrayException("Index out of bound: " + index);
        }

        LOGGER.info("Successfully retrieved value by index: {}", index);
        return array[index];
    }

    public void set(final int index, final int value) throws CustomIntArrayException {
        final boolean isValid = boundsValidator(index, array.length);

        if (!isValid) {
            throw new CustomIntArrayException("Index out of bound: " + index);
        }

        LOGGER.info("Successfully set value by index: {}", index);
        array[index] = value;
    }

    public int length() {
        LOGGER.info("Successfully retrieved CustomIntArray size.");
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        LOGGER.debug("Comparing CustomIntArray with another object");
        if (o == null || getClass() != o.getClass()) return false;

        final CustomIntArray that = (CustomIntArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        LOGGER.debug("Calculated hashCode.");
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomIntArray.class.getSimpleName() + "[", "]")
                .add("array=" + Arrays.toString(array))
                .toString();
    }

    private boolean boundsValidator (final int index, final int arrayLength) {
        LOGGER.debug("Validating array bounds.");

        int minIndex = 0;
        if (index >= arrayLength || index < minIndex) {
            LOGGER.error("Index out of bound: {}", index);
            return false;
        }

        return true;
    }
}