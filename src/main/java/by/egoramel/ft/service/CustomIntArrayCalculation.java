package by.egoramel.ft.service;

import by.egoramel.ft.entity.CustomIntArray;

public interface CustomIntArrayCalculation {
    int findMin(final CustomIntArray customIntArray);
    int findMax(final CustomIntArray customIntArray);
    int calculateSum(final CustomIntArray customIntArray);
    int calculateAvg(final CustomIntArray customIntArray);
}