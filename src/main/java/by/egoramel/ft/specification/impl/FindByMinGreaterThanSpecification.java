package by.egoramel.ft.specification.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.service.CustomIntArrayCalculation;
import by.egoramel.ft.service.impl.CustomIntArrayCalculationImpl;
import by.egoramel.ft.specification.Specification;

@SuppressWarnings("unused")
public final class FindByMinGreaterThanSpecification implements Specification {
    private final int necessaryMin;

    public FindByMinGreaterThanSpecification(final int necessaryMax) {
        this.necessaryMin = necessaryMax;
    }

    @Override
    public boolean matches(final CustomIntArray CustomIntArray) {
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();
        final int customIntArrayMin = customIntArrayCalculation.findMin(CustomIntArray);
        return customIntArrayMin > necessaryMin;
    }
}