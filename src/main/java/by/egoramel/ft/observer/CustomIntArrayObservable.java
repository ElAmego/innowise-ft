package by.egoramel.ft.observer;

import by.egoramel.ft.entity.CustomIntArray;

public interface CustomIntArrayObservable {
    void addCustomIntArrayObserver(final CustomIntArrayObserver customIntArrayObserver);
    void removeCustomIntArrayObserver();
    void notifyCustomIntArrayObservers(final CustomIntArray customIntArray);
}