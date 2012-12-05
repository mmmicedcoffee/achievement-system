package statistic;

import statistic.constants.StatisticKey;

public class Statistic {
    private final StatisticKey id;
    private int value;

    public Statistic(StatisticKey id, int initialValue) {
        this.id = id;
        this.value = initialValue;
    }

    public void update(Statistic stat) {
        assert (id == stat.getId());
        this.value += stat.getValue();
    }

    public StatisticKey getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
