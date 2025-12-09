package by.egoramel.ft.comparator;

import by.egoramel.ft.entity.CustomIntArray;

import java.util.Comparator;

@SuppressWarnings("unused")
public final class CustomIntArrayLengthComparator implements Comparator<CustomIntArray> {
    @Override
    public int compare(final CustomIntArray arr1, final CustomIntArray arr2) {
        final int arr1Length = arr1.length();
        final int arr2Length = arr2.length();
        return Integer.compare(arr1Length, arr2Length);
    }
}