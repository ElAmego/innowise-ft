package by.egoramel.ft.entity;

import by.egoramel.ft.validator.CustomIntArrayValidator;
import by.egoramel.ft.validator.impl.CustomIntArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

@SuppressWarnings("unused")
public class CustomIntArray {
    private final Logger logger = LogManager.getLogger(CustomIntArray.class);
    private final CustomIntArrayValidator customIntArrayValidator = new CustomIntArrayValidatorImpl();
    private final int[] array;

    public CustomIntArray(final int size) {
        logger.info("Successful CustomIntArray creation with size: {}", size);
        this.array = new int[size];
    }

    public CustomIntArray(final int[] initialArray) {
        logger.info("Successful CustomIntArray creation from array: {}", Arrays.toString(initialArray));
        this.array = Arrays.copyOf(initialArray, initialArray.length);
    }

    public int get(final int index) {
        customIntArrayValidator.validateBounds(index, array.length);

        logger.info("Successfully retrieved value by index: {}", index);
        return array[index];
    }

    public void set(final int index, final int value) {
        customIntArrayValidator.validateBounds(index, array.length);

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