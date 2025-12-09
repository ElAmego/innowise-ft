package by.egoramel.ft.entity;

public record CustomIntArrayData(int max, int min, int avg, int sum) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CustomIntArrayData that = (CustomIntArrayData) o;
        return max == that.max && min == that.min && avg == that.avg && sum == that.sum;
    }

    @Override
    public int hashCode() {
        int result = max;
        result = 31 * result + min;
        result = 31 * result + avg;
        result = 31 * result + sum;
        return result;
    }
}