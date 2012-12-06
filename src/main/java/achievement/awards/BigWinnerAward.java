package achievement.awards;

import achievement.Achievement;
import statistic.StatSet;

import static statistic.constants.StatAttribute.LIFETIME;
import static statistic.constants.StatKey.WINS;

public class BigWinnerAward implements Achievement {
    public static final int THRESHOLD = 200;

    @Override
    public boolean evaluate(StatSet aStatSet) {
        if (aStatSet.getAttribute() != LIFETIME) {
            return false;
        }
        return aStatSet.getStat(WINS) >= THRESHOLD;
    }

    @Override
    public void claim() {
        System.out.println("Congratulations, you have won the Big Winner Award!");
    }
}
