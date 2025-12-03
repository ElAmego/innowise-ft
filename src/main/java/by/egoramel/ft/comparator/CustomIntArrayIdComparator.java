package by.egoramel.ft.comparator;

import by.egoramel.ft.entity.CustomIntArray;

import java.util.Comparator;

public final class CustomIntArrayIdComparator implements Comparator<CustomIntArray> {

    @Override
    public int compare(final CustomIntArray arr1, final CustomIntArray arr2) {
        final long arr1Id = arr1.getId();
        final long arr2Id = arr2.getId();
        return Long.compare(arr1Id, arr2Id);
    }
}