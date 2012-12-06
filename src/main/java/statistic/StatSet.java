package statistic;

import statistic.constants.StatAttribute;
import statistic.constants.StatKey;

import java.util.Iterator;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static statistic.constants.StatParameters.INITIAL_STAT_VALUE;

public class StatSet implements Iterable<Statistic> {
    private final StatAttribute attribute;
    private Map<StatKey, Statistic> statistics;

    public StatSet(StatAttribute attribute) {
        this.attribute = attribute;
        init();
    }

    private void init() {
        statistics = newHashMap();
        for (StatKey stat : StatKey.values()) {
            statistics.put(stat, new Statistic(stat, INITIAL_STAT_VALUE));
        }
    }

    public void update(StatKey key, int value) {
        this.update(new Statistic(key, value));
    }

    public void update(Statistic stat) {
        final StatKey statId = stat.getId();
        statistics.get(statId).update(stat);
    }

    public int getStatisticValue(StatKey statId) {
        assert (statistics.containsKey(statId));
        return statistics.get(statId).getValue();
    }

    public Statistic getStatistic(StatKey statId) {
        assert (statistics.containsKey(statId));
        return statistics.get(statId);
    }

    public StatAttribute getAttribute() {
        return attribute;
    }

    @Override
    public Iterator<Statistic> iterator() {
        return statistics.values().iterator();
    }

    @Override
    public String toString() {
        String statisticsString = "";

        for (StatKey statKey : StatKey.values()) {
            final Statistic stat = statistics.get(statKey);
            statisticsString += stat.getId().toString() + ": " + String.valueOf(stat.getValue()) + "\n";
        }

        return statisticsString;
    }
}
