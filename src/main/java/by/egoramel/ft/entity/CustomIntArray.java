package by.egoramel.ft.entity;

import by.egoramel.ft.exception.CustomIntArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.StringJoiner;

@SuppressWarnings("unused")
public final class CustomIntArray {
    private static final Logger LOGGER = LogManager.getLogger();
    private final int[] array;
    private final long id;

    public CustomIntArray(final int size, final long id) {
        LOGGER.info("Successful CustomIntArray creation with size: {}", size);
        this.array = new int[size];
        this.id = id;
    }

    public CustomIntArray(final int[] initialArray, final long id) {
        LOGGER.info("Successful CustomIntArray creation from array: {}", Arrays.toString(initialArray));
        this.array = Arrays.copyOf(initialArray, initialArray.length);
        this.id = id;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CustomIntArray that = (CustomIntArray) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomIntArray.class.getSimpleName() + "[", "]")
                .add("array=" + Arrays.toString(array))
                .add("id=" + id)
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

    public long getId() {
        return id;
    }

    public int[] getArray() {
        return array;
    }
}