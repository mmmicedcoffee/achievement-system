package achievement.awards;

import achievement.Achievement;
import statistic.StatSet;

import static statistic.constants.StatAttribute.LIFETIME;
import static statistic.constants.StatKey.LOSSES;
import static statistic.constants.StatKey.WINS;

public class VeteranAward implements Achievement {
    public static final int THRESHOLD = 1000;

    @Override
    public boolean evaluate(StatSet aStatSet) {
        if (aStatSet.getAttribute() != LIFETIME) {
            return false;
        }
        return (aStatSet.getStat(WINS) + aStatSet.getStat(LOSSES)) >= THRESHOLD;
    }

    @Override
    public void claim() {
        System.out.println("Congratulations, you have won the Veteran Award!");
    }
}
