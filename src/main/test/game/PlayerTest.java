package game;

import achievement.Achievement;
import org.junit.Before;
import org.junit.Test;
import statistic.StatSet;
import statistic.StatSetFactory;
import statistic.constants.StatKey;

import static com.google.common.collect.Sets.newHashSet;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static statistic.constants.StatAttribute.GAME;
import static statistic.constants.StatAttribute.LIFETIME;
import static statistic.constants.StatKey.WINS;
import static statistic.constants.StatParameters.MAX_TIME_PLAYED;

public class PlayerTest {
    private static final String NAME = "TEST";
    private static final int ACHIEVEMENT_THRESHOLD = 100;

    private Achievement achievement;
    private StatSet gameStats;
    private StatSet lifetimeStats;
    private Player player;

    @Before
    public void setUp() throws Exception {
        achievement = createMock(Achievement.class);
        lifetimeStats = new StatSet(LIFETIME);
        player = new Player(NAME, lifetimeStats, newHashSet(achievement));
    }

    @Test
    public void testUpdateStats() throws Exception {
        final StatSetFactory statFactory = new StatSetFactory();
        gameStats = statFactory.generateRandomGameStats(true, MAX_TIME_PLAYED);
        player.updateStats(gameStats);
        for (StatKey key : StatKey.values()) {
            assertEquals(gameStats.getStat(key), player.getStat(key));
        }
    }

    @Test
    public void testEvaluateAchievements() throws Exception {
        gameStats = new StatSet(GAME);
        gameStats.setStat(WINS, ACHIEVEMENT_THRESHOLD);
        player.updateStats(gameStats);

        expect(achievement.evaluate(gameStats)).andReturn(true);
        expect(achievement.evaluate(lifetimeStats)).andReturn(false);
        achievement.claim();
        expectLastCall().once();

        replay(achievement);

        player.evaluateAchievements();

        verify(achievement);
    }
}
