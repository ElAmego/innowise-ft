package by.egoramel.ft.specification;

import by.egoramel.ft.entity.CustomIntArray;

@FunctionalInterface
public interface Specification {
    boolean matches(final CustomIntArray customIntArray);
}