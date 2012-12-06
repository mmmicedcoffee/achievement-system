package statistic;

import org.junit.Test;
import statistic.constants.StatKey;

import static org.junit.Assert.assertEquals;
import static statistic.constants.StatParameters.INITIAL_STAT_VALUE;

public class StatisticTest {
    private static final int UPDATED_STAT_VALUE = 1;

    @Test
    public void testInit() {
        for (StatKey key : StatKey.values()) {
            final Statistic stat = new Statistic(key, INITIAL_STAT_VALUE);
            assertEquals(key, stat.getId());
            assertEquals(INITIAL_STAT_VALUE, stat.getValue());
        }
    }

    @Test
    public void testUpdate() {
        for (StatKey key : StatKey.values()) {
            final Statistic stat = new Statistic(key, INITIAL_STAT_VALUE);
            stat.update(new Statistic(key, UPDATED_STAT_VALUE));
            assertEquals(key, stat.getId());
            assertEquals(UPDATED_STAT_VALUE, stat.getValue());
        }
    }
}
