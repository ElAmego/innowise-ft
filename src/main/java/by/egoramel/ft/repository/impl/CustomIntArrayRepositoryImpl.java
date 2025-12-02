package by.egoramel.ft.repository.impl;

import by.egoramel.ft.comparator.CustomIntArrayIdComparator;
import by.egoramel.ft.comparator.CustomIntArrayLengthComparator;
import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.observer.CustomIntArrayObserver;
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

public final class CustomIntArrayRepositoryImpl implements CustomIntArrayRepository, CustomIntArrayObserver {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final CustomIntArrayRepository INSTANCE = new CustomIntArrayRepositoryImpl();
    private final CustomIntArrayWarehouse customIntArrayWarehouse = CustomIntArrayWarehouseImpl.getInstance();
    private final List<CustomIntArray> customIntArrayList = new ArrayList<>();

    @Override
    public void save(final CustomIntArray customIntArray) throws CustomIntArrayException {
        final long customIntArrayId = customIntArray.getId();
        final Optional<CustomIntArray> existingCustomIntArray = findCustomIntArrayById(customIntArrayId);

        if (existingCustomIntArray.isPresent()) {
            throw new CustomIntArrayException("Array already exists.");
        } else {
            customIntArray.addCustomIntArrayObserver(this);
            customIntArray.addCustomIntArrayObserver(customIntArrayWarehouse);
            customIntArrayList.add(customIntArray);
            customIntArrayWarehouse.addInitialData(customIntArray);
        }
    }

    @Override
    public void remove(final CustomIntArray customIntArray) throws CustomIntArrayException {
        final long customIntArrayId = customIntArray.getId();
        final Optional<CustomIntArray> existingCustomIntArray = findCustomIntArrayById(customIntArrayId);

        if (existingCustomIntArray.isPresent()) {
            customIntArray.removeCustomIntArrayObserver(this);
            customIntArray.removeCustomIntArrayObserver(customIntArrayWarehouse);
            customIntArrayList.remove(existingCustomIntArray.get());
            customIntArrayWarehouse.removeData(customIntArrayId);
        } else {
            throw new CustomIntArrayException("Array doesn't exist.");
        }
    }

    @Override
    public Optional<CustomIntArray> findCustomIntArrayById(final long id) {
        return customIntArrayList.stream()
                .filter(customIntArray -> customIntArray.getId() == id)
                .findFirst();
    }

    @Override
    public List<CustomIntArray> findAll() {
        return new ArrayList<>(customIntArrayList);
    }

    @Override
    public List<CustomIntArray> findBySumGreaterThan(final int necessarySum) throws CustomIntArrayException {
        final List<CustomIntArray> result = new ArrayList<>();
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();

        for (final CustomIntArray customIntArray: customIntArrayList) {
            final int customIntArraySum = customIntArrayCalculation.calculateSum(customIntArray);

            if (customIntArraySum > necessarySum) {
                result.add(customIntArray);
            }
        }

        return result;
    }

    @Override
    public List<CustomIntArray> findByAvgGreaterThan(final int necessaryAvg) throws CustomIntArrayException {
        final List<CustomIntArray> result = new ArrayList<>();
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();

        for (final CustomIntArray customIntArray: customIntArrayList) {
            final int customIntArrayAvg = customIntArrayCalculation.calculateAvg(customIntArray);

            if (customIntArrayAvg > necessaryAvg) {
                result.add(customIntArray);
            }
        }

        return result;
    }

    @Override
    public List<CustomIntArray> findByMaxGreaterThan(final int necessaryMax) throws CustomIntArrayException {
        final List<CustomIntArray> result = new ArrayList<>();
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();

        for (final CustomIntArray customIntArray: customIntArrayList) {
            final int customIntArrayMax = customIntArrayCalculation.findMax(customIntArray);

            if (customIntArrayMax > necessaryMax) {
                result.add(customIntArray);
            }
        }

        return result;
    }

    @Override
    public List<CustomIntArray> findByMinGreaterThan(final int necessaryMin) throws CustomIntArrayException {
        final List<CustomIntArray> result = new ArrayList<>();
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();

        for (final CustomIntArray customIntArray: customIntArrayList) {
            final int customIntArrayMin = customIntArrayCalculation.findMin(customIntArray);

            if (customIntArrayMin > necessaryMin) {
                result.add(customIntArray);
            }
        }

        return result;
    }

    @Override
    public List<CustomIntArray> sortAllByIdAsc() {
        final List<CustomIntArray> customIntArrays = findAll();
        final CustomIntArrayIdComparator customIntArrayIdComparator = new CustomIntArrayIdComparator();

        customIntArrays.sort(customIntArrayIdComparator);
        return customIntArrays;
    }


    @Override
    public List<CustomIntArray> sortAllByIdDesc() {
        final List<CustomIntArray> customIntArrays = findAll();
        final CustomIntArrayIdComparator customIntArrayIdComparator = new CustomIntArrayIdComparator();
        Comparator<CustomIntArray> reversedCustomIntArrayIdComparator = customIntArrayIdComparator.reversed();

        customIntArrays.sort(reversedCustomIntArrayIdComparator);
        return customIntArrays;
    }

    @Override
    public List<CustomIntArray> sortAllByLengthAsc() {
        final List<CustomIntArray> customIntArrays = findAll();
        final CustomIntArrayLengthComparator customIntArrayLengthComparator = new CustomIntArrayLengthComparator();

        customIntArrays.sort(customIntArrayLengthComparator);
        return customIntArrays;
    }

    @Override
    public List<CustomIntArray> sortAllByLengthDesc() {
        final List<CustomIntArray> customIntArrays = findAll();
        final CustomIntArrayLengthComparator customIntArrayLengthComparator = new CustomIntArrayLengthComparator();
        final Comparator<CustomIntArray> reversedCustomIntArrayLengthComparator = customIntArrayLengthComparator.reversed();

        customIntArrays.sort(reversedCustomIntArrayLengthComparator);
        return customIntArrays;
    }

    public static CustomIntArrayRepository getInstance() {
        return INSTANCE;
    }

    private CustomIntArrayRepositoryImpl() {

    }

    @Override
    public void onCustomIntArrayChanged(final CustomIntArray customIntArray) {
        LOGGER.debug("Repository notified about change in array ID: {}.", customIntArray.getId());
    }
}