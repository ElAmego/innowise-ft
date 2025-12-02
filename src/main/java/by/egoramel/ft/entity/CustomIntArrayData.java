package by.egoramel.ft.entity;

import java.util.StringJoiner;

public final class CustomIntArrayData {
    private final long id;
    private final int max;
    private final int min;
    private final int avg;
    private final int sum;

    public CustomIntArrayData(final long id, final int max, final int min, final int avg, final int sum) {
        this.id = id;
        this.max = max;
        this.min = min;
        this.avg = avg;
        this.sum = sum;
    }

    public long getId() {
        return id;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getAvg() {
        return avg;
    }

    public int getSum() {
        return sum;
    }

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