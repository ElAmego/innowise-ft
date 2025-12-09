package by.egoramel.ft.repository;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;
import by.egoramel.ft.specification.Specification;

import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public interface CustomIntArrayRepository {
    void save (final CustomIntArray customIntArray) throws CustomIntArrayException;
    void remove (final CustomIntArray customIntArray) throws CustomIntArrayException;
    List<CustomIntArray> find(final Specification specification);
    List<CustomIntArray> sort(final Comparator<CustomIntArray> comparator);
    int getRepositorySize();
}