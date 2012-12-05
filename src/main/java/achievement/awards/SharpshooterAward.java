package achievement.awards;

import achievement.Achievement;
import statistic.StatisticSet;
import statistic.constants.StatisticKey;

import static statistic.constants.StatisticKey.NUM_ATTEMPTED_ATTACKS;
import static statistic.constants.StatisticKey.NUM_HITS;

public class SharpshooterAward implements Achievement {
    @Override
    public boolean evaluate(StatisticSet aStatisticSet) {
        final int attempted = aStatisticSet.getStatistic(NUM_ATTEMPTED_ATTACKS).getValue();
        if (attempted == 0) return false;
        final int hit = aStatisticSet.getStatistic(NUM_HITS).getValue();
        return (hit / (float) attempted) >= 0.75;
    }

    @Override
    public void claim() {
        System.out.println("Congratulations, you have won the Sharpshooter Award!");
    }
}
