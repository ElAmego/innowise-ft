package by.egoramel.ft.specification.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.service.CustomIntArrayCalculation;
import by.egoramel.ft.service.impl.CustomIntArrayCalculationImpl;
import by.egoramel.ft.specification.Specification;

@SuppressWarnings("unused")
public final class FindByAvgGreaterThanSpecification implements Specification {
    private final int necessaryAvg;

    public FindByAvgGreaterThanSpecification(final int necessaryAvg) {
        this.necessaryAvg = necessaryAvg;
    }

    @Override
    public boolean matches(final CustomIntArray CustomIntArray) {
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();
        final int customIntArrayAvg = customIntArrayCalculation.calculateAvg(CustomIntArray);
        return customIntArrayAvg > necessaryAvg;
    }
}