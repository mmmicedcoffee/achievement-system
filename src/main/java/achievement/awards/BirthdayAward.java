package achievement.awards;

/*
 * Awarded for having a score that commemorates LoL's birthday (release date) on
 * Oct 27, 2009 - get 10 kills and 27 assists in one game to claim this award.
 */

import achievement.Achievement;
import statistic.StatSet;

import static statistic.constants.StatAttribute.GAME;
import static statistic.constants.StatKey.ASSISTS;
import static statistic.constants.StatKey.KILLS;

public class BirthdayAward implements Achievement {
    public static final int EXPECTED_KILLS = 10;
    public static final int EXPECTED_ASSISTS = 27;

    @Override
    public boolean evaluate(StatSet aStatSet) {
        if (aStatSet.getAttribute() != GAME) {
            return false;
        }
        final int numKills = aStatSet.getStat(KILLS);
        final int numAssists = aStatSet.getStat(ASSISTS);
        return ((numKills == EXPECTED_KILLS) && (numAssists == EXPECTED_ASSISTS));
    }

    @Override
    public void claim() {
        System.out.println("Congratulations, you have won the Birthday Award!");
    }
}
