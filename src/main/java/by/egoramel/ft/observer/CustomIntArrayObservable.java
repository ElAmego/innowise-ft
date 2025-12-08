package by.egoramel.ft.observer;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;

public interface CustomIntArrayObservable {
    void addCustomIntArrayObserver(final CustomIntArrayObserver customIntArrayObserver);
    void removeCustomIntArrayObserver();
    void notifyCustomIntArrayObservers(final CustomIntArray customIntArray) throws CustomIntArrayException;
}