package statistic;

import statistic.constants.StatAttribute;

import java.util.Random;

import static statistic.constants.StatKey.*;
import static statistic.constants.StatParameters.MAX_DMG;
import static statistic.constants.StatParameters.MAX_KILLS;
import static statistic.constants.StatParameters.MAX_NUM_HITS;

public class StatSetFactory {
    public StatSet generateRandomGameStats(boolean win, int gameLength) {
        final StatSet statistics = new StatSet(StatAttribute.GAME);
        // record win/loss
        if (win) {
            statistics.update(WINS, 1);
        } else {
            statistics.update(LOSSES, 1);
        }
        // record game length
        statistics.update(TIME_PLAYED, gameLength);

        // random stats
        Random random = new Random();
        final int attemptedHits = random.nextInt(MAX_NUM_HITS);
        statistics.update(ATTEMPTED_HITS, attemptedHits);
        statistics.update(HITS, random.nextInt(MAX_NUM_HITS) % attemptedHits);
        final int dmgDone = attemptedHits == 0 ? 0 : random.nextInt(MAX_DMG);
        statistics.update(DMG_DONE, dmgDone);
        final int numKills = dmgDone == 0 ? 0 : random.nextInt(MAX_KILLS);
        statistics.update(KILLS, numKills);
        final int numFirstHitKills = numKills == 0 ? 0 : random.nextInt(MAX_KILLS) % numKills;
        statistics.update(FIRST_HIT_KILLS, numFirstHitKills);
        statistics.update(ASSISTS, random.nextInt(MAX_KILLS));
        final int spellCasts = random.nextInt(MAX_NUM_HITS);
        statistics.update(SPELL_CASTS, spellCasts);
        statistics.update(SPELL_DMG, spellCasts == 0 ? 0 : random.nextInt(MAX_DMG));
        return statistics;
    }
}
