package statistic;

import statistic.constants.StatAttribute;
import statistic.constants.StatKey;

import java.util.Iterator;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static java.util.Map.Entry;
import static statistic.constants.StatParameters.INITIAL_STAT_VALUE;

public class StatSet implements Iterable<Entry<StatKey, Integer>> {
    private final StatAttribute attribute;
    private Map<StatKey, Integer> statistics;

    public StatSet(StatAttribute attribute) {
        this.attribute = attribute;
        init();
    }

    private void init() {
        statistics = newHashMap();
        for (StatKey stat : StatKey.values()) {
            statistics.put(stat, INITIAL_STAT_VALUE);
        }
    }

    public void update(StatKey key, int value) {
        if (statistics.containsKey(key)) {
            statistics.put(key, statistics.get(key) + value);
        } else {
            statistics.put(key, value);
        }
    }

    public int getStat(StatKey key) {
        assert (statistics.containsKey(key));
        return statistics.get(key);
    }

    public StatAttribute getAttribute() {
        return attribute;
    }

    @Override
    public Iterator<Entry<StatKey, Integer>> iterator() {
        return statistics.entrySet().iterator();
    }

    @Override
    public String toString() {
        String statisticsString = "";

        for (StatKey key : StatKey.values()) {
            statisticsString += key.toString() + ": " + String.valueOf(statistics.get(key)) + "\n";
        }

        return statisticsString;
    }
}
