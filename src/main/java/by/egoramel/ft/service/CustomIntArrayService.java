package by.egoramel.ft.service;

import by.egoramel.ft.entity.CustomIntArray;

public interface CustomIntArrayService {
    int getMin(final CustomIntArray customIntArray);
    int getMax(final CustomIntArray customIntArray);
    int getSum(final CustomIntArray customIntArray);
    CustomIntArray bubbleSort(final CustomIntArray customIntArray);
    CustomIntArray selectionSort(final CustomIntArray customIntArray);
}