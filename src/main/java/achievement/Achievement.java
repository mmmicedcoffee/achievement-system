package achievement;

import statistic.StatisticSet;

public interface Achievement {
    boolean evaluate(StatisticSet aStatisticSet);

    void claim();
}
