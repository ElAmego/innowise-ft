package by.egoramel.ft.warehouse.impl;

import by.egoramel.ft.entity.CustomIntArrayData;
import by.egoramel.ft.warehouse.CustomIntArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public final class CustomIntArrayWarehouseImpl implements CustomIntArrayWarehouse {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final CustomIntArrayWarehouse instance = new CustomIntArrayWarehouseImpl();
    private final Map<Long, CustomIntArrayData> storage = new HashMap<>();

    public static CustomIntArrayWarehouse getInstance() {
        LOGGER.trace("Getting Warehouse singleton instance.");
        return instance;
    }

    private CustomIntArrayWarehouseImpl() {

    }

    @Override
    public void put(final long id, final CustomIntArrayData customIntArrayData) {
        storage.put(id, customIntArrayData);
        LOGGER.info("Warehouse updated statistics for array ID: {}", id);
    }

    @Override
    public void removeData(final long id) {
        LOGGER.debug("Removing data by ID: {}.", id);
        storage.remove(id);
    }
}