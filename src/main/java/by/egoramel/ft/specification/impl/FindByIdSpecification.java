package by.egoramel.ft.specification.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.specification.Specification;

@SuppressWarnings("Unused")
public final class FindByIdSpecification implements Specification {
    private final long necessaryId;

    public FindByIdSpecification(final long necessaryId) {
        this.necessaryId = necessaryId;
    }

    @Override
    public boolean matches(final CustomIntArray customIntArray) {
        return customIntArray.getId() == necessaryId;
    }
}