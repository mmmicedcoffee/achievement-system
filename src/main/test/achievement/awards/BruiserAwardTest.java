package achievement.awards;

import org.junit.Before;
import org.junit.Test;
import statistic.StatSet;

import static achievement.awards.BruiserAward.THRESHOLD;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static statistic.constants.StatAttribute.GAME;
import static statistic.constants.StatAttribute.LIFETIME;
import static statistic.constants.StatKey.DMG_DONE;

public class BruiserAwardTest {
    private static final int OFFSET = 100;
    private BruiserAward award;
    private StatSet stats;

    @Before
    public void before() {
        award = new BruiserAward();
        stats = createMock(StatSet.class);
    }

    @Test
    public void testEvaluateTrue() {
        expect(stats.getAttribute()).andReturn(GAME);
        expect(stats.getStat(DMG_DONE)).andReturn(THRESHOLD + OFFSET);
        replay(stats);
        assertTrue(award.evaluate(stats));
        verify(stats);
    }

    @Test
    public void testEvaluateFalse() {
        expect(stats.getAttribute()).andReturn(GAME);
        expect(stats.getStat(DMG_DONE)).andReturn(THRESHOLD - OFFSET);
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
