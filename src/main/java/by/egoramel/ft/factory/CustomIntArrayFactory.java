package by.egoramel.ft.factory;

import by.egoramel.ft.entity.CustomIntArray;

public interface CustomIntArrayFactory {
    CustomIntArray createEmptyCustomIntArray();
    CustomIntArray createWithSizeCustomIntArray(final int size);
    CustomIntArray createFromArrayCustomIntArray(final int[] initialArray);
    CustomIntArray createFromFileCustomIntArray();
}
