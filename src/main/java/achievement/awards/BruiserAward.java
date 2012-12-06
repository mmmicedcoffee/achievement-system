package achievement.awards;

import achievement.Achievement;
import statistic.StatSet;

import static statistic.constants.StatAttribute.GAME;
import static statistic.constants.StatKey.DMG_DONE;

public class BruiserAward implements Achievement {
    public static final int THRESHOLD = 500;

    @Override
    public boolean evaluate(StatSet aStatSet) {
        if (aStatSet.getAttribute() != GAME) {
            return false;
        }
        return aStatSet.getStatistic(DMG_DONE).getValue() > THRESHOLD;
    }

    @Override
    public void claim() {
        System.out.println("Congratulations, you have won the Bruiser Award!");
    }
}
