package statistic;

import statistic.constants.StatisticParameters;

import java.util.Random;

import static statistic.constants.StatisticKey.*;
import static statistic.constants.StatisticParameters.MAX_DMG;
import static statistic.constants.StatisticParameters.MAX_KILLS;
import static statistic.constants.StatisticParameters.MAX_NUM_HITS;

public class StatisticSetFactory {
    public StatisticSet generateStats(boolean win, int gameLength) {
        final StatisticSet statistics = new StatisticSet();
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
        statistics.update(NUM_ATTEMPTED_ATTACKS, attemptedHits);
        statistics.update(NUM_HITS, random.nextInt(MAX_NUM_HITS) % attemptedHits);
        final int dmgDone = attemptedHits == 0 ? 0 : random.nextInt(MAX_DMG);
        statistics.update(DMG_DONE, dmgDone);
        final int numKills = dmgDone == 0 ? 0 : random.nextInt(MAX_KILLS);
        statistics.update(NUM_KILLS, numKills);
        statistics.update(NUM_FIRST_HIT_KILLS, random.nextInt(MAX_KILLS) % numKills);
        statistics.update(NUM_ASSISTS, random.nextInt(MAX_KILLS));
        final int spellCasts = random.nextInt(MAX_NUM_HITS);
        statistics.update(NUM_SPELL_CASTS, spellCasts);
        statistics.update(SPELL_DMG, spellCasts == 0 ? 0 : random.nextInt(MAX_DMG));
        return statistics;
    }
}
