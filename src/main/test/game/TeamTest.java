package game;

import org.junit.Before;
import org.junit.Test;
import statistic.StatSet;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

public class TeamTest {
    private static final String NAME = "TEST";
    private static final int PLAYER_INDEX = 0;

    private StatSet gameStats;
    private Player player;
    private Team team;

    @Before
    public void setUp() throws Exception {
        gameStats = createMock(StatSet.class);
        player = createMock(Player.class);
        team = new Team(NAME, new Player[]{player});
    }

    @Test
    public void testUpdateStatsForPlayer() throws Exception {
        player.updateStats(gameStats);
        expectLastCall().once();
        replay(player);
        team.updateStatsForPlayer(PLAYER_INDEX, gameStats);
        verify(player);
    }
}
