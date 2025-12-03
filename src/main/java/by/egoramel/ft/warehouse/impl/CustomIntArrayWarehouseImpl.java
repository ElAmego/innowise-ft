package by.egoramel.ft.warehouse.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.entity.CustomIntArrayData;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.service.CustomIntArrayCalculation;
import by.egoramel.ft.service.impl.CustomIntArrayCalculationImpl;
import by.egoramel.ft.warehouse.CustomIntArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public final class CustomIntArrayWarehouseImpl implements CustomIntArrayWarehouse {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final CustomIntArrayWarehouse INSTANCE = new CustomIntArrayWarehouseImpl();
    private final Map<Long, CustomIntArrayData> storage = new HashMap<>();

    @Override
    public void onCustomIntArrayChanged(final CustomIntArray customIntArray) throws CustomIntArrayException {
        LOGGER.debug("Warehouse received change notification for array ID: {}.", customIntArray.getId());
        updateData(customIntArray);
    }

    @Override
    public void updateData(final CustomIntArray customIntArray) throws CustomIntArrayException {
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();
        final long id = customIntArray.getId();
        LOGGER.debug("Updating warehouse data for array ID: {}", id);

        final int max = customIntArrayCalculation.findMax(customIntArray);
        final int min = customIntArrayCalculation.findMin(customIntArray);
        final int avg = customIntArrayCalculation.calculateAvg(customIntArray);
        final int sum = customIntArrayCalculation.calculateSum(customIntArray);
        final CustomIntArrayData customIntArrayData = new CustomIntArrayData(id, max, min, avg, sum);

        storage.put(id, customIntArrayData);

        LOGGER.info("Warehouse updated statistics for array ID: {}", id);
    }

    public void addInitialData(final CustomIntArray customIntArray) throws CustomIntArrayException {
        LOGGER.debug("Adding initial data to warehouse for array ID: {}.", customIntArray.getId());
        updateData(customIntArray);
    }

    @Override
    public void removeData(final long id) {
        LOGGER.debug("Removing data by ID: {}.", id);
        storage.remove(id);
    }

    public static CustomIntArrayWarehouse getInstance() {
        LOGGER.trace("Getting Warehouse singleton instance.");
        return INSTANCE;
    }

    public Map<Long, CustomIntArrayData> getStorage() {
        LOGGER.trace("Getting Warehouse storage.");
        return Map.copyOf(storage);
    }

    private CustomIntArrayWarehouseImpl() {

    }
}