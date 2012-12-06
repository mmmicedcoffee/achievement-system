package statistic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static statistic.constants.StatKey.LOSSES;
import static statistic.constants.StatKey.TIME_PLAYED;
import static statistic.constants.StatKey.WINS;

public class StatSetFactoryTest {
    private static final int GAME_LENGTH = 20;

    private StatSetFactory factory;

    @Before
    public void before() {
        factory = new StatSetFactory();
    }

    @Test
    public void testWin() {
        final StatSet statistics = factory.generateRandomGameStats(true, GAME_LENGTH);
        assertEquals(1, statistics.getStat(WINS));
        assertEquals(0, statistics.getStat(LOSSES));
        assertEquals(GAME_LENGTH, statistics.getStat(TIME_PLAYED));
    }

    @Test
    public void testLoss() {
        final StatSet statistics = factory.generateRandomGameStats(false, GAME_LENGTH);
        assertEquals(0, statistics.getStat(WINS));
        assertEquals(1, statistics.getStat(LOSSES));
        assertEquals(GAME_LENGTH, statistics.getStat(TIME_PLAYED));
    }
}
