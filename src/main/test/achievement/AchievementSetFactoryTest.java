package achievement;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class AchievementSetFactoryTest {
    private AchievementSetFactory testFactory;

    @Before
    public void before() {
        testFactory = new AchievementSetFactory();
    }

    @Test
    public void testAchievementSetFactory() {
        HashSet<Achievement> achievements = testFactory.createFullAchievementSet();
        assertEquals(4, achievements.size());
    }
}
