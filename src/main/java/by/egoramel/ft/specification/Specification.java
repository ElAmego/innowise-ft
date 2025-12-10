package by.egoramel.ft.specification;

import by.egoramel.ft.entity.CustomIntArray;

public interface Specification {
    boolean matches(final CustomIntArray customIntArray);
}