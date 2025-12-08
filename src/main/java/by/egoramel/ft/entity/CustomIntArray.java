package by.egoramel.ft.entity;

import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.observer.CustomIntArrayObservable;
import by.egoramel.ft.observer.CustomIntArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.StringJoiner;

@SuppressWarnings("unused")
public final class CustomIntArray implements CustomIntArrayObservable {
    private static final Logger LOGGER = LogManager.getLogger();
    private final long id;
    private final int[] array;
    public CustomIntArrayObserver customIntArrayObserver;

    public CustomIntArray(final int size, final long id) {
        LOGGER.info("Successful CustomIntArray creation with size: {}.", size);
        this.array = new int[size];
        this.id = id;
        LOGGER.debug("CustomIntArray with id: {} and size: {} created.", id, size);
    }

    public CustomIntArray(final int[] initialArray, final long id) {
        LOGGER.info("Successful CustomIntArray creation from array: {}.", Arrays.toString(initialArray));
        this.array = Arrays.copyOf(initialArray, initialArray.length);
        this.id = id;
        LOGGER.debug("CustomIntArray with id {} created from initial array.", id);
    }

    public int get(final int index) throws CustomIntArrayException {
        LOGGER.debug("Getting value by index: {}.", index);
        final boolean isValid = boundsValidator(index, array.length);

        if (!isValid) {
            LOGGER.error("Failed to get value: index {} out of bounds.", index);
            throw new CustomIntArrayException("Index out of bound: " + index);
        }

        LOGGER.info("Successfully retrieved value by index: {}", index);
        return array[index];
    }

    public void set(final int index, final int value) throws CustomIntArrayException {
        LOGGER.debug("Setting value {} at index: {}.", value, index);
        final boolean isValid = boundsValidator(index, array.length);

        if (!isValid) {
            LOGGER.error("Failed to set value: index {} out of bounds.", index);
            throw new CustomIntArrayException("Index out of bound: " + index);
        }

        LOGGER.info("Successfully set value by index: {}", index);
        array[index] = value;
        LOGGER.debug("Notifying observer for array ID: {}.", id);
        notifyCustomIntArrayObservers(this);
    }

    public int length() {
        LOGGER.info("Successfully retrieved CustomIntArray size.");
        return array.length;
    }

    public long getId() {
        LOGGER.trace("Getting ID of array: {}.", id);
        return id;
    }

    @Override
    public void addCustomIntArrayObserver(final CustomIntArrayObserver observer) {
        LOGGER.debug("Adding observer to array ID: {}.", id);
        if (customIntArrayObserver == null) {
            customIntArrayObserver = observer;
            initializeObserverData(observer);
            LOGGER.info("Observer added to array ID: {}.", id);
        }
    }

    private void initializeObserverData(final CustomIntArrayObserver observer) {
        LOGGER.debug("Initializing warehouse data for array ID: {}.", id);
        observer.onCustomIntArrayChanged(this);
    }

    @Override
    public void removeCustomIntArrayObserver() {
        customIntArrayObserver = null;
        LOGGER.info("Observer removed from array ID: {}.", id);
    }

    @Override
    public void notifyCustomIntArrayObservers(final CustomIntArray CustomIntArray) {
        customIntArrayObserver.onCustomIntArrayChanged(CustomIntArray);
        LOGGER.trace("Observer notified successfully.");
    }

    @Override
    public boolean equals(final Object o) {
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

        LOGGER.trace("Bounds validation passed.");
        return true;
    }
}