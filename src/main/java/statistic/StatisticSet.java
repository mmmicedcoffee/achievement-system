package statistic;

import statistic.constants.StatisticKey;

import java.util.Iterator;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static statistic.constants.StatisticParameters.INITIAL_STAT_VALUE;

public class StatisticSet implements Iterable<Statistic> {
    private Map<StatisticKey, Statistic> statistics;

    public StatisticSet() {
        init();
    }

    private void init() {
        statistics = newHashMap();
        for (StatisticKey stat : StatisticKey.values()) {
            statistics.put(stat, new Statistic(stat, INITIAL_STAT_VALUE));
        }
    }

    public void update(StatisticKey key, int value) {
        this.update(new Statistic(key, value));
    }

    public void update(Statistic stat) {
        final StatisticKey statId = stat.getId();
        statistics.get(statId).update(stat);
    }

    public Statistic getStatistic(StatisticKey statId) {
        assert (statistics.containsKey(statId));
        return statistics.get(statId);
    }

    @Override
    public Iterator<Statistic> iterator() {
        return statistics.values().iterator();
    }

    @Override
    public String toString() {
        String statisticsString = "";

        for (StatisticKey statKey : StatisticKey.values()) {
            final Statistic stat = statistics.get(statKey);
            statisticsString += stat.getId().toString() + ": " + String.valueOf(stat.getValue()) + "\n";
        }

        return statisticsString;
    }
}
