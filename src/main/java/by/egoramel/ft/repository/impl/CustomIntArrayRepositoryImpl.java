package by.egoramel.ft.repository.impl;

import by.egoramel.ft.comparator.CustomIntArrayIdComparator;
import by.egoramel.ft.comparator.CustomIntArrayLengthComparator;
import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.repository.CustomIntArrayRepository;
import by.egoramel.ft.service.CustomIntArrayCalculation;
import by.egoramel.ft.service.impl.CustomIntArrayCalculationImpl;
import by.egoramel.ft.warehouse.CustomIntArrayWarehouse;
import by.egoramel.ft.warehouse.impl.CustomIntArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class CustomIntArrayRepositoryImpl implements CustomIntArrayRepository {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final CustomIntArrayRepository INSTANCE = new CustomIntArrayRepositoryImpl();
    private final CustomIntArrayWarehouse customIntArrayWarehouse = CustomIntArrayWarehouseImpl.getInstance();
    private final List<CustomIntArray> customIntArrayList = new ArrayList<>();

    @Override
    public void save(final CustomIntArray customIntArray) throws CustomIntArrayException {
        final long customIntArrayId = customIntArray.getId();
        LOGGER.debug("Attempting to save CustomIntArray with ID: {}.", customIntArrayId);

        final Optional<CustomIntArray> existingCustomIntArray = findCustomIntArrayById(customIntArrayId);

        if (existingCustomIntArray.isPresent()) {
            LOGGER.error("Failed to save: array with ID {} already exist.", customIntArrayId);
            throw new CustomIntArrayException("Array already exists.");
        } else {
            LOGGER.trace("Registering warehouse as observer for array ID: {}.", customIntArrayId);
            customIntArray.addCustomIntArrayObserver(customIntArrayWarehouse);

            LOGGER.debug("Adding array with ID {} to repository list.", customIntArrayId);
            customIntArrayList.add(customIntArray);

            LOGGER.trace("Initializing warehouse data for array ID: {}.", customIntArrayId);
            customIntArrayWarehouse.addInitialData(customIntArray);
        }
    }

    @Override
    public void remove(final CustomIntArray customIntArray) throws CustomIntArrayException {
        final long customIntArrayId = customIntArray.getId();

        LOGGER.debug("Attempting to remove CustomIntArray with ID: {}.", customIntArrayId);
        final Optional<CustomIntArray> existingCustomIntArray = findCustomIntArrayById(customIntArrayId);

        if (existingCustomIntArray.isPresent()) {
            LOGGER.trace("Removing warehouse observer from array ID: {}.", customIntArrayId);
            customIntArray.removeCustomIntArrayObserver(customIntArrayWarehouse);

            LOGGER.debug("Removing array with ID {} from repository list.", customIntArrayId);
            customIntArrayList.remove(existingCustomIntArray.get());

            LOGGER.trace("Removing warehouse data for array ID: {}.", customIntArrayId);
            customIntArrayWarehouse.removeData(customIntArrayId);
        } else {
            LOGGER.error("Failed to remove: array with ID {} doesn't exist.", customIntArrayId);
            throw new CustomIntArrayException("Array doesn't exist.");
        }
    }

    @Override
    public Optional<CustomIntArray> findCustomIntArrayById(final long id) {
        LOGGER.trace("Searching for CustomIntArray with ID: {}.", id);
        return customIntArrayList.stream()
                .filter(customIntArray -> customIntArray.getId() == id)
                .findFirst();
    }

    @Override
    public List<CustomIntArray> findAll() {
        LOGGER.trace("Retrieving all CustomIntArrays from repository.");
        return new ArrayList<>(customIntArrayList);
    }

    @Override
    public List<CustomIntArray> findBySumGreaterThan(final int necessarySum) throws CustomIntArrayException {
        LOGGER.debug("Searching for arrays with sum greater than {}.", necessarySum);
        final List<CustomIntArray> result = new ArrayList<>();
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();

        for (final CustomIntArray customIntArray: customIntArrayList) {
            final int customIntArraySum = customIntArrayCalculation.calculateSum(customIntArray);
            LOGGER.trace("Array ID {} sum: {}.", customIntArray.getId(), customIntArraySum);

            if (customIntArraySum > necessarySum) {
                result.add(customIntArray);
                LOGGER.trace("Array ID {} meets sum criteria.", customIntArray.getId());
            }
        }

        return result;
    }

    @Override
    public List<CustomIntArray> findByAvgGreaterThan(final int necessaryAvg) throws CustomIntArrayException {
        LOGGER.debug("Searching for arrays with average greater than {}", necessaryAvg);
        final List<CustomIntArray> result = new ArrayList<>();
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();

        for (final CustomIntArray customIntArray: customIntArrayList) {
            final int customIntArrayAvg = customIntArrayCalculation.calculateAvg(customIntArray);
            LOGGER.trace("Array ID {} average: {}.", customIntArray.getId(), customIntArrayAvg);

            if (customIntArrayAvg > necessaryAvg) {
                result.add(customIntArray);
                LOGGER.trace("Array ID {} meets average criteria.", customIntArray.getId());
            }
        }

        return result;
    }

    @Override
    public List<CustomIntArray> findByMaxGreaterThan(final int necessaryMax) throws CustomIntArrayException {
        LOGGER.debug("Searching for arrays with max greater than {}.", necessaryMax);
        final List<CustomIntArray> result = new ArrayList<>();
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();

        for (final CustomIntArray customIntArray: customIntArrayList) {
            final int customIntArrayMax = customIntArrayCalculation.findMax(customIntArray);
            LOGGER.trace("Array ID {} max: {}.", customIntArray.getId(), customIntArrayMax);

            if (customIntArrayMax > necessaryMax) {
                result.add(customIntArray);
                LOGGER.trace("Array ID {} meets max criteria.", customIntArray.getId());
            }
        }

        return result;
    }

    @Override
    public List<CustomIntArray> findByMinGreaterThan(final int necessaryMin) throws CustomIntArrayException {
        LOGGER.debug("Searching for arrays with min greater than {}.", necessaryMin);
        final List<CustomIntArray> result = new ArrayList<>();
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();

        for (final CustomIntArray customIntArray: customIntArrayList) {
            final int customIntArrayMin = customIntArrayCalculation.findMin(customIntArray);
            LOGGER.trace("Array ID {} min: {}.", customIntArray.getId(), customIntArrayMin);

            if (customIntArrayMin > necessaryMin) {
                result.add(customIntArray);
                LOGGER.trace("Array ID {} meets min criteria.", customIntArray.getId());
            }
        }

        return result;
    }

    @Override
    public List<CustomIntArray> sortAllByIdAsc() {
        LOGGER.debug("Sorting all arrays by ID ascending.");
        final List<CustomIntArray> customIntArrays = findAll();
        final CustomIntArrayIdComparator customIntArrayIdComparator = new CustomIntArrayIdComparator();

        customIntArrays.sort(customIntArrayIdComparator);
        return customIntArrays;
    }

    @Override
    public List<CustomIntArray> sortAllByIdDesc() {
        LOGGER.debug("Sorting all arrays by ID descending.");
        final List<CustomIntArray> customIntArrays = findAll();
        final CustomIntArrayIdComparator customIntArrayIdComparator = new CustomIntArrayIdComparator();
        Comparator<CustomIntArray> reversedCustomIntArrayIdComparator = customIntArrayIdComparator.reversed();

        customIntArrays.sort(reversedCustomIntArrayIdComparator);
        return customIntArrays;
    }

    @Override
    public List<CustomIntArray> sortAllByLengthAsc() {
        LOGGER.debug("Sorting all arrays by length ascending.");
        final List<CustomIntArray> customIntArrays = findAll();
        final CustomIntArrayLengthComparator customIntArrayLengthComparator = new CustomIntArrayLengthComparator();

        customIntArrays.sort(customIntArrayLengthComparator);
        return customIntArrays;
    }

    @Override
    public List<CustomIntArray> sortAllByLengthDesc() {
        LOGGER.debug("Sorting all arrays by length descending.");
        final List<CustomIntArray> customIntArrays = findAll();
        final CustomIntArrayLengthComparator customIntArrayLengthComparator = new CustomIntArrayLengthComparator();
        final Comparator<CustomIntArray> reversedCustomIntArrayLengthComparator = customIntArrayLengthComparator.reversed();

        customIntArrays.sort(reversedCustomIntArrayLengthComparator);
        return customIntArrays;
    }

    @Override
    public int getRepositorySize() {
        return customIntArrayList.size();
    }

    public static CustomIntArrayRepository getInstance() {
        LOGGER.trace("Getting Repository singleton instance.");
        return INSTANCE;
    }

    private CustomIntArrayRepositoryImpl() {

    }
}