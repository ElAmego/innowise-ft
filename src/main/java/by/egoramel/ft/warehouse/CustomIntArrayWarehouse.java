package by.egoramel.ft.warehouse;

import by.egoramel.ft.entity.CustomIntArrayData;

public interface CustomIntArrayWarehouse {
    void put(final long id, final CustomIntArrayData CustomIntArrayData);
    void removeData(final long id);
    CustomIntArrayData getData(final long id);
}