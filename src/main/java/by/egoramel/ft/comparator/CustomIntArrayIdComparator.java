package by.egoramel.ft.comparator;

import by.egoramel.ft.entity.CustomIntArray;

import java.util.Comparator;

public final class CustomIntArrayIdComparator implements Comparator<CustomIntArray> {

    @Override
    public int compare(final CustomIntArray arr1, final CustomIntArray arr2) {
        return Long.compare(arr1.getId(), arr2.getId());
    }
}
