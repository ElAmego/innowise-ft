package by.egoramel.ft.observer;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;

public interface CustomIntArrayObserver {
    void onCustomIntArrayChanged(final CustomIntArray customIntArray) throws CustomIntArrayException;
}
