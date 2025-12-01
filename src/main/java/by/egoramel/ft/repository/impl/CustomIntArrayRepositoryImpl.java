package by.egoramel.ft.repository.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.repository.CustomIntArrayRepository;
import by.egoramel.ft.service.CustomIntArrayCalculation;
import by.egoramel.ft.service.impl.CustomIntArrayCalculationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomIntArrayRepositoryImpl implements CustomIntArrayRepository {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final CustomIntArrayRepositoryImpl INSTANCE = new CustomIntArrayRepositoryImpl();
    private final List<CustomIntArray> customIntArrayList = new ArrayList<>();

    private CustomIntArrayRepositoryImpl() {

    }

    @Override
    public void save(final CustomIntArray customIntArray) throws CustomIntArrayException {
        final long customIntArrayId = customIntArray.getId();
        final Optional<CustomIntArray> existingCustomIntArray = findCustomIntArrayById(customIntArrayId);

        if (existingCustomIntArray.isPresent()) {
            throw new CustomIntArrayException("Array already exists.");
        } else {
            customIntArrayList.add(customIntArray);
        }
    }

    @Override
    public void remove(final CustomIntArray customIntArray) throws CustomIntArrayException {
        final long customIntArrayId = customIntArray.getId();
        final Optional<CustomIntArray> existingCustomIntArray = findCustomIntArrayById(customIntArrayId);

        if (existingCustomIntArray.isPresent()) {
            customIntArrayList.remove(existingCustomIntArray.get());
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
            final int customIntArrayAvg = customIntArrayCalculation.calculateSum(customIntArray) / customIntArray.length();

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

    public static CustomIntArrayRepositoryImpl getInstance() {
        return INSTANCE;
    }
}