package by.egoramel.ft.specification.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.entity.CustomIntArrayData;
import by.egoramel.ft.specification.Specification;
import by.egoramel.ft.warehouse.CustomIntArrayWarehouse;
import by.egoramel.ft.warehouse.impl.CustomIntArrayWarehouseImpl;

@SuppressWarnings("unused")
public final class FindByMinGreaterThanSpecification implements Specification {
    private final int necessaryMin;

    public FindByMinGreaterThanSpecification(final int necessaryMax) {
        this.necessaryMin = necessaryMax;
    }

    @Override
    public boolean matches(final CustomIntArray customIntArray) {
        final CustomIntArrayWarehouse customIntArrayWarehouse = CustomIntArrayWarehouseImpl.getInstance();
        final long customIntArrayId = customIntArray.getId();
        final CustomIntArrayData customIntArrayData = customIntArrayWarehouse.getData(customIntArrayId);
        final int customIntArrayMin = customIntArrayData.min();
        return customIntArrayMin > necessaryMin;
    }
}