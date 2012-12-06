package achievement.awards;

import org.junit.Before;
import org.junit.Test;
import statistic.StatSet;

import static achievement.awards.BirthdayAward.EXPECTED_ASSISTS;
import static achievement.awards.BirthdayAward.EXPECTED_KILLS;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static statistic.constants.StatAttribute.GAME;
import static statistic.constants.StatAttribute.LIFETIME;
import static statistic.constants.StatKey.ASSISTS;
import static statistic.constants.StatKey.KILLS;

public class BirthdayAwardTest {
    public static final int OFFSET = 1;
    private BirthdayAward award;
    private StatSet stats;

    @Before
    public void before() {
        award = new BirthdayAward();
        stats = createMock(StatSet.class);
    }

    @Test
    public void testEvaluateTrue() {
        expect(stats.getAttribute()).andReturn(GAME);
        expect(stats.getStat(KILLS)).andReturn(EXPECTED_KILLS);
        expect(stats.getStat(ASSISTS)).andReturn(EXPECTED_ASSISTS);
        replay(stats);
        assertTrue(award.evaluate(stats));
        verify(stats);
    }

    @Test
    public void testEvaluateIncorrectKills() {
        expect(stats.getAttribute()).andReturn(GAME);
        expect(stats.getStat(KILLS)).andReturn(EXPECTED_KILLS + 1);
        expect(stats.getStat(ASSISTS)).andReturn(EXPECTED_ASSISTS);
        replay(stats);
        assertFalse(award.evaluate(stats));
        verify(stats);
    }

    @Test
    public void testEvaluateIncorrectAssists() {
        expect(stats.getAttribute()).andReturn(GAME);
        expect(stats.getStat(KILLS)).andReturn(EXPECTED_KILLS);
        expect(stats.getStat(ASSISTS)).andReturn(EXPECTED_ASSISTS + 1);
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
