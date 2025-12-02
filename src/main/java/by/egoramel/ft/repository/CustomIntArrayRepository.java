package by.egoramel.ft.repository;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.exception.CustomIntArrayException;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
public interface CustomIntArrayRepository {
    void save (final CustomIntArray customIntArray) throws CustomIntArrayException;
    void remove (final CustomIntArray customIntArray) throws CustomIntArrayException;
    Optional<CustomIntArray> findCustomIntArrayById(final long id);
    List<CustomIntArray> findAll();
    List<CustomIntArray> findBySumGreaterThan(int necessarySum) throws CustomIntArrayException;
    List<CustomIntArray> findByAvgGreaterThan(int necessaryAvg) throws CustomIntArrayException;
    List<CustomIntArray> findByMaxGreaterThan(int necessaryMax) throws CustomIntArrayException;
    List<CustomIntArray> findByMinGreaterThan(int necessaryMin) throws CustomIntArrayException;
    List<CustomIntArray> sortAllByIdAsc();
    List<CustomIntArray> sortAllByIdDesc();
    List<CustomIntArray> sortAllByLengthAsc();
    List<CustomIntArray> sortAllByLengthDesc();
}
