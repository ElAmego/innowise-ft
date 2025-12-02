package by.egoramel.ft.comparator;

import by.egoramel.ft.entity.CustomIntArray;

import java.util.Comparator;

public final class CustomIntArrayLengthComparator implements Comparator<CustomIntArray> {
    @Override
    public int compare(final CustomIntArray arr1, final CustomIntArray arr2) {
        return Integer.compare(arr1.length(), arr2.length());
    }
}
