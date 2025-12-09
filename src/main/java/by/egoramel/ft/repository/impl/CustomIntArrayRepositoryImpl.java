package by.egoramel.ft.repository.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.observer.CustomIntArrayObserver;
import by.egoramel.ft.observer.impl.CustomIntArrayObserverImpl;
import by.egoramel.ft.repository.CustomIntArrayRepository;
import by.egoramel.ft.specification.Specification;
import by.egoramel.ft.specification.impl.FindByIdSpecification;
import by.egoramel.ft.warehouse.CustomIntArrayWarehouse;
import by.egoramel.ft.warehouse.impl.CustomIntArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class CustomIntArrayRepositoryImpl implements CustomIntArrayRepository {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final CustomIntArrayRepository instance = new CustomIntArrayRepositoryImpl();
    private final List<CustomIntArray> customIntArrayList = new ArrayList<>();

    public static CustomIntArrayRepository getInstance() {
        LOGGER.trace("Getting Repository singleton instance.");
        return instance;
    }

    private CustomIntArrayRepositoryImpl() {

    }

    @Override
    public void save(final CustomIntArray customIntArray) throws CustomIntArrayException {
        final long customIntArrayId = customIntArray.getId();
        LOGGER.debug("Attempting to save CustomIntArray with ID: {}.", customIntArrayId);

        final Specification specification = new FindByIdSpecification(customIntArrayId);
        final List<CustomIntArray> existingCustomIntArray = find(specification);

        if (existingCustomIntArray.isEmpty()) {
            LOGGER.trace("Registering warehouse as observer for array ID: {}.", customIntArrayId);
            final CustomIntArrayObserver customIntArrayObserver = new CustomIntArrayObserverImpl();
            customIntArray.addCustomIntArrayObserver(customIntArrayObserver);

            LOGGER.debug("Adding array with ID {} to repository list.", customIntArrayId);
            customIntArrayList.add(customIntArray);
        } else {
            LOGGER.error("Failed to save: array with ID {} already exist.", customIntArrayId);
            throw new CustomIntArrayException("Array already exists.");
        }
    }

    @Override
    public void remove(final CustomIntArray customIntArray) throws CustomIntArrayException {
        final CustomIntArrayWarehouse customIntArrayWarehouse = CustomIntArrayWarehouseImpl.getInstance();
        final long customIntArrayId = customIntArray.getId();
        LOGGER.debug("Attempting to remove CustomIntArray with ID: {}.", customIntArrayId);
        final Specification specification = new FindByIdSpecification(customIntArrayId);
        final List<CustomIntArray> existingCustomIntArray = find(specification);

        if (!existingCustomIntArray.isEmpty()) {
            LOGGER.trace("Removing warehouse observer from array ID: {}.", customIntArrayId);
            customIntArray.removeCustomIntArrayObserver();

            LOGGER.debug("Removing array with ID {} from repository list.", customIntArrayId);
            customIntArrayList.remove(existingCustomIntArray.getFirst());

            LOGGER.trace("Removing warehouse data for array ID: {}.", customIntArrayId);
            customIntArrayWarehouse.removeData(customIntArrayId);
        } else {
            LOGGER.error("Failed to remove: array with ID {} doesn't exist.", customIntArrayId);
            throw new CustomIntArrayException("Array doesn't exist.");
        }
    }

    @Override
    public List<CustomIntArray> find(final Specification specification) {
        return customIntArrayList.stream()
                .filter(specification::matches)
                .toList();
    }

    @Override
    public List<CustomIntArray> sort(final Comparator<CustomIntArray> comparator) {
        final List<CustomIntArray> customIntArrays = new ArrayList<>(List.copyOf(customIntArrayList));
        customIntArrays.sort(comparator);
        return customIntArrays;
    }

    @Override
    public int getRepositorySize() {
        return customIntArrayList.size();
    }
}