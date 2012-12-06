package achievement.awards;

import org.junit.Before;
import org.junit.Test;
import statistic.StatSet;
import statistic.Statistic;

import static achievement.awards.VeteranAward.THRESHOLD;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static statistic.constants.StatAttribute.GAME;
import static statistic.constants.StatAttribute.LIFETIME;
import static statistic.constants.StatKey.LOSSES;
import static statistic.constants.StatKey.WINS;

public class VeteranAwardTest {
    public static final int OFFSET = 100;
    public static final int HALF_THRESHOLD = (int) Math.round(0.5 * THRESHOLD);
    private VeteranAward award;
    private StatSet stats;

    @Before
    public void before() {
        award = new VeteranAward();
        stats = createMock(StatSet.class);
    }

    @Test
    public void testEvaluateTrue() {
        expect(stats.getAttribute()).andReturn(LIFETIME);
        expect(stats.getStatistic(WINS)).andReturn(new Statistic(WINS, HALF_THRESHOLD + OFFSET));
        expect(stats.getStatistic(LOSSES)).andReturn(new Statistic(LOSSES, HALF_THRESHOLD + OFFSET));
        replay(stats);
        assertTrue(award.evaluate(stats));
        verify(stats);
    }

    @Test
    public void testEvaluateFalse() {
        expect(stats.getAttribute()).andReturn(LIFETIME);
        expect(stats.getStatistic(WINS)).andReturn(new Statistic(WINS, HALF_THRESHOLD - OFFSET));
        expect(stats.getStatistic(LOSSES)).andReturn(new Statistic(LOSSES, HALF_THRESHOLD - OFFSET));
        replay(stats);
        assertFalse(award.evaluate(stats));
        verify(stats);
    }

    @Test
    public void testEvaluateWrongAttribute() {
        expect(stats.getAttribute()).andReturn(GAME);
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
