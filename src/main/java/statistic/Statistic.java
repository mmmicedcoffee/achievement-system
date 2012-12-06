package statistic;

import statistic.constants.StatKey;

public class Statistic {
    private final StatKey id;
    private int value;

    public Statistic(StatKey id, int initialValue) {
        this.id = id;
        this.value = initialValue;
    }

    public void update(Statistic stat) {
        assert (id == stat.getId());
        this.value += stat.getValue();
    }

    public StatKey getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
