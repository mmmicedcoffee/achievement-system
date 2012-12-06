package achievement.awards;

/*
 * Awarded for recalling back to base more than 10 times in one game.
 */

import achievement.Achievement;
import statistic.StatSet;

import static statistic.constants.StatAttribute.GAME;
import static statistic.constants.StatKey.RECALLS;

public class HomesickAward implements Achievement {
    public static final int THRESHOLD = 10;

    @Override
    public boolean evaluate(StatSet aStatSet) {
        if (aStatSet.getAttribute() != GAME) {
            return false;
        }
        return aStatSet.getStat(RECALLS) > THRESHOLD;
    }

    @Override
    public void claim() {
        System.out.println("Congratulations, you have won the Homesick Award!");
    }
}
