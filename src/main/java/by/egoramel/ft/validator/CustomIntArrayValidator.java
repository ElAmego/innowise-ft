package by.egoramel.ft.validator;

import by.egoramel.ft.entity.CustomIntArray;

import java.util.List;

public interface CustomIntArrayValidator {
    void validationOnNegativeSize(final int size);
    void validateStringList(final List<String> stringList);
    void validateCustomIntArray(final CustomIntArray customIntArray, final String message);
    void validateArray(final int[] array);
    void validateBounds(final int index, final int arrayLength);
}