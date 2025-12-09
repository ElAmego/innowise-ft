package by.egoramel.ft.specification.impl;

import by.egoramel.ft.entity.CustomIntArray;
import by.egoramel.ft.service.CustomIntArrayCalculation;
import by.egoramel.ft.service.impl.CustomIntArrayCalculationImpl;
import by.egoramel.ft.specification.Specification;

@SuppressWarnings("unused")
public final class FindBySumGreaterThanSpecification implements Specification {
    private final int necessarySum;

    public FindBySumGreaterThanSpecification(final int necessarySum) {
        this.necessarySum = necessarySum;
    }

    @Override
    public boolean matches(final CustomIntArray CustomIntArray) {
        final CustomIntArrayCalculation customIntArrayCalculation = new CustomIntArrayCalculationImpl();
        final int customIntArraySum = customIntArrayCalculation.calculateSum(CustomIntArray);
        return customIntArraySum > necessarySum;
    }
}