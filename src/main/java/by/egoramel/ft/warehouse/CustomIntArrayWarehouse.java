package by.egoramel.ft.warehouse;

import by.egoramel.ft.entity.CustomIntArrayData;
import by.egoramel.ft.exception.CustomIntArrayException;

import java.util.Map;

public interface CustomIntArrayWarehouse {
    void addData(final long id, final CustomIntArrayData CustomIntArrayData) throws CustomIntArrayException;
    void removeData(final long id);
    Map<Long, CustomIntArrayData> getMap();
}
