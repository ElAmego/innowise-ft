package by.egoramel.ft.specification.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.service.CustomIntArrayCalculation;
import by.egoramel.ft.service.impl.CustomIntArrayCalculationImpl;
import by.egoramel.ft.specification.Specification;

@SuppressWarnings("unused")
public final class FindByMaxGreaterThanSpecification implements Specification {
    private final int necessaryMax;

    public FindByMaxGreaterThanSpecification(final int necessaryMax) {
        this.necessaryMax = necessaryMax;
    }

    @Override
    public boolean matches(final CustomIntArray CustomIntArray) {
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();
        final int customIntArrayMax = customIntArrayCalculation.findMax(CustomIntArray);
        return customIntArrayMax > necessaryMax;
    }
}