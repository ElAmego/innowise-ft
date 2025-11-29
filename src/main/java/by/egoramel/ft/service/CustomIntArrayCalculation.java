package by.egoramel.ft.service;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;

public interface CustomIntArrayCalculation {
    int findMin(final CustomIntArray customIntArray) throws CustomIntArrayException;
    int findMax(final CustomIntArray customIntArray) throws CustomIntArrayException;
    int calculateSum(final CustomIntArray customIntArray) throws CustomIntArrayException;
}