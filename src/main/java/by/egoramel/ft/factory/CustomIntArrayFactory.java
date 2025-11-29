package by.egoramel.ft.factory;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;

public interface CustomIntArrayFactory {
    CustomIntArray createWithSizeCustomIntArray(final int size) throws CustomIntArrayException;
    CustomIntArray createFromArrayCustomIntArray(final int[] initialArray) throws CustomIntArrayException;
    CustomIntArray createFromFileCustomIntArray() throws CustomIntArrayException;
}