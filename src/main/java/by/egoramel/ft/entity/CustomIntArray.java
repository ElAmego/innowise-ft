package by.egoramel.ft.entity;

import by.egoramel.ft.exception.CustomIntArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

@SuppressWarnings("unused")
public class CustomIntArray {
    private final int[] array;
    private final Logger logger = LogManager.getLogger(CustomIntArray.class);

    protected CustomIntArray(final int size) {
        logger.debug("Creating CustomIntArray with size: {}", size);
        if (size < 0) {
            logger.error("Attempt to create CustomIntArray with incorrect size: {}", size);
            throw new CustomIntArrayException("Array size cannot be negative: " + size);
        }

        logger.info("Successful CustomIntArray creation with size: {}", size);
        this.array = new int[size];
    }

    protected CustomIntArray(final int[] initialArray) {
        logger.debug("Creating CustomIntArray from array: {}", Arrays.toString(initialArray));

        if (initialArray == null) {
            logger.error("Attempt to create null CustomIntArray.");
            throw new CustomIntArrayException("Array size cannot be null.");
        }

        logger.info("Successful CustomIntArray creation from array: {}", Arrays.toString(initialArray));
        this.array = Arrays.copyOf(initialArray, initialArray.length);
    }

    public int get(final int index) {
        logger.debug("Getting value by index: {}", index);
        if (index >= array.length || index < 0) {
            logger.error("Attempt to get value by incorrect index: {}", index);
            throw new CustomIntArrayException("Index out of bound: " + index);
        }

        logger.info("Successfully retrieved value by index: {}", index);
        return array[index];
    }

    public void set(final int index, final int value) {
        logger.debug("Setting value by index: {}", index);
        if (index >= array.length || index < 0) {
            logger.error("Attempt to set value by incorrect index: {}", index);
            throw new CustomIntArrayException("Index out of bound: " + index);
        }

        logger.info("Successfully set value by index: {}", index);
        array[index] = value;
    }

    public int length() {
        logger.info("Successfully retrieved CustomIntArray size.");
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        logger.debug("Comparing CustomIntArray with another object");
        if (o == null || getClass() != o.getClass()) return false;

        final CustomIntArray that = (CustomIntArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        logger.debug("Calculated hashCode.");
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        logger.debug("Converting array to string.");
        final StringBuilder sb = new StringBuilder("CustomIntArray{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}