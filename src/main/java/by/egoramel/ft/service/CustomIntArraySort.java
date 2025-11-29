package by.egoramel.ft.service;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;

public interface CustomIntArraySort {
    CustomIntArray bubbleSort(final CustomIntArray customIntArray) throws CustomIntArrayException;
    CustomIntArray selectionSort(final CustomIntArray customIntArray) throws CustomIntArrayException;
}
