package statistic;

import org.junit.Test;
import statistic.constants.StatKey;

import static org.junit.Assert.assertEquals;
import static statistic.constants.StatAttribute.GAME;
import static statistic.constants.StatAttribute.LIFETIME;
import static statistic.constants.StatKey.KILLS;
import static statistic.constants.StatParameters.INITIAL_STAT_VALUE;

public class StatSetTest {
    private static final StatKey TEST_STAT = KILLS;
    private static final int UPDATED_STAT_VALUE = 1;

    @Test
    public void testInitLifetimeSet() {
        final StatSet statistics = new StatSet(LIFETIME);
        for (StatKey key : StatKey.values()) {
            assertEquals(INITIAL_STAT_VALUE, statistics.getStatisticValue(key));
        }
        assertEquals(LIFETIME, statistics.getAttribute());
    }

    @Test
    public void testInitGameSet() {
        final StatSet statistics = new StatSet(GAME);
        for (StatKey key : StatKey.values()) {
            assertEquals(INITIAL_STAT_VALUE, statistics.getStatisticValue(key));
        }
        assertEquals(GAME, statistics.getAttribute());
    }

    @Test
    public void testUpdateLifetimeSet() {
        final StatSet statistics = new StatSet(LIFETIME);
        statistics.update(TEST_STAT, UPDATED_STAT_VALUE);
        for (StatKey key : StatKey.values()) {
            if (key == TEST_STAT) {
                assertEquals(UPDATED_STAT_VALUE, statistics.getStatisticValue(key));
            } else {
                assertEquals(INITIAL_STAT_VALUE, statistics.getStatisticValue(key));
            }
        }
        assertEquals(LIFETIME, statistics.getAttribute());
    }

    @Test
    public void testUpdateGameSet() {
        final StatSet statistics = new StatSet(GAME);
        statistics.update(TEST_STAT, UPDATED_STAT_VALUE);
        for (StatKey key : StatKey.values()) {
            if (key == TEST_STAT) {
                assertEquals(UPDATED_STAT_VALUE, statistics.getStatisticValue(key));
            } else {
                assertEquals(INITIAL_STAT_VALUE, statistics.getStatisticValue(key));
            }
        }
        assertEquals(GAME, statistics.getAttribute());
    }
}
