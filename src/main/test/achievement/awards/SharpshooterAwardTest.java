package achievement.awards;

import org.junit.Before;
import org.junit.Test;
import statistic.StatSet;
import statistic.Statistic;

import static achievement.awards.SharpshooterAward.THRESHOLD;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static statistic.constants.StatAttribute.GAME;
import static statistic.constants.StatAttribute.LIFETIME;
import static statistic.constants.StatKey.ATTEMPTED_HITS;
import static statistic.constants.StatKey.HITS;

public class SharpshooterAwardTest {
    public static final double OFFSET = 0.1;
    public static final int N = 100;
    private SharpshooterAward award;
    private StatSet stats;

    @Before
    public void before() {
        award = new SharpshooterAward();
        stats = createMock(StatSet.class);
    }

    @Test
    public void testEvaluateTrue() {
        expect(stats.getAttribute()).andReturn(GAME);
        expect(stats.getStatistic(ATTEMPTED_HITS)).andReturn(new Statistic(ATTEMPTED_HITS, N));
        expect(stats.getStatistic(HITS)).andReturn(new Statistic(HITS, (int) Math.round((THRESHOLD + OFFSET) * N)));
        replay(stats);
        assertTrue(award.evaluate(stats));
        verify(stats);
    }

    @Test
    public void testEvaluateFalse() {
        expect(stats.getAttribute()).andReturn(GAME);
        expect(stats.getStatistic(ATTEMPTED_HITS)).andReturn(new Statistic(ATTEMPTED_HITS, N));
        expect(stats.getStatistic(HITS)).andReturn(new Statistic(HITS, (int) Math.round((THRESHOLD - OFFSET) * N)));
        replay(stats);
        assertFalse(award.evaluate(stats));
        verify(stats);
    }

    @Test
    public void testEvaluateWrongAttribute() {
        expect(stats.getAttribute()).andReturn(LIFETIME);
        replay(stats);
        assertFalse(award.evaluate(stats));
        verify(stats);
    }

    @Test
    public void testClaim() {
        // test claim runs without breaking anything
        award.claim();
    }
}
