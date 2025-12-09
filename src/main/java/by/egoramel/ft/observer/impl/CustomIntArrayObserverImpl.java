package by.egoramel.ft.observer.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.entity.CustomIntArrayData;
import by.egoramel.ft.observer.CustomIntArrayObserver;
import by.egoramel.ft.service.CustomIntArrayCalculation;
import by.egoramel.ft.service.impl.CustomIntArrayCalculationImpl;
import by.egoramel.ft.warehouse.CustomIntArrayWarehouse;
import by.egoramel.ft.warehouse.impl.CustomIntArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CustomIntArrayObserverImpl implements CustomIntArrayObserver {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onCustomIntArrayChanged(final CustomIntArray customIntArray) {
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();
        final long id = customIntArray.getId();
        LOGGER.debug("Calculating data for array ID: {}.", id);

        final int max = customIntArrayCalculation.findMax(customIntArray);
        final int min = customIntArrayCalculation.findMin(customIntArray);
        final int avg = customIntArrayCalculation.calculateAvg(customIntArray);
        final int sum = customIntArrayCalculation.calculateSum(customIntArray);

        final CustomIntArrayData customIntArrayData = new CustomIntArrayData(max, min, avg, sum);
        final CustomIntArrayWarehouse customIntArrayWarehouse = CustomIntArrayWarehouseImpl.getInstance();
        customIntArrayWarehouse.put(id, customIntArrayData);
    }
}