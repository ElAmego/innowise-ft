package by.egoramel.ft.warehouse;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.entity.CustomIntArrayData;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.observer.CustomIntArrayObserver;

import java.util.Map;

public interface CustomIntArrayWarehouse extends CustomIntArrayObserver {
    void updateData(final CustomIntArray customIntArray) throws CustomIntArrayException;
    void addInitialData(final CustomIntArray customIntArray) throws CustomIntArrayException;
    void removeData(final long id);
    Map<Long, CustomIntArrayData> getStorage();
}
