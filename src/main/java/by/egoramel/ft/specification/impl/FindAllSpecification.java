package by.egoramel.ft.specification.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.specification.Specification;

@SuppressWarnings("unused")
public final class FindAllSpecification implements Specification {
    @Override
    public boolean matches(final CustomIntArray customIntArray) {
        return true;
    }
}