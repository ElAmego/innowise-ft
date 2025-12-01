package by.egoramel.ft.factory;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;

public interface CustomIntArrayFactory {
    CustomIntArray createWithSizeCustomIntArray(final int size, final long id) throws CustomIntArrayException;
    CustomIntArray createFromArrayCustomIntArray(final int[] initialArray, final long id) throws CustomIntArrayException;
    CustomIntArray createFromFileCustomIntArray(final long id) throws CustomIntArrayException;
}