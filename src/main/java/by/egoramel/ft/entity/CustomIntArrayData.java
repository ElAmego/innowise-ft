package by.egoramel.ft.entity;

import java.util.StringJoiner;

public record CustomIntArrayData(long id, int max, int min, int avg, int sum) {

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomIntArrayData.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("max=" + max)
                .add("min=" + min)
                .add("avg=" + avg)
                .add("sum=" + sum)
                .toString();
    }
}