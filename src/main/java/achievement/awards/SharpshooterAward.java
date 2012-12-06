package achievement.awards;

import achievement.Achievement;
import statistic.StatSet;

import static statistic.constants.StatAttribute.GAME;
import static statistic.constants.StatKey.ATTEMPTED_HITS;
import static statistic.constants.StatKey.HITS;

public class SharpshooterAward implements Achievement {
    public static final double THRESHOLD = 0.75;

    @Override
    public boolean evaluate(StatSet aStatSet) {
        if (aStatSet.getAttribute() != GAME) {
            return false;
        }
        final int attempted = aStatSet.getStatistic(ATTEMPTED_HITS).getValue();
        if (attempted == 0) return false;
        final int hit = aStatSet.getStatistic(HITS).getValue();
        return (hit / (float) attempted) >= THRESHOLD;
    }

    @Override
    public void claim() {
        System.out.println("Congratulations, you have won the Sharpshooter Award!");
    }
}
