package achievement.awards;

import achievement.Achievement;
import statistic.StatisticSet;

import static statistic.constants.StatisticKey.DMG_DONE;

public class BruiserAward implements Achievement {
    @Override
    public boolean evaluate(StatisticSet aStatisticSet) {
        return aStatisticSet.getStatistic(DMG_DONE).getValue() > 500d;
    }

    @Override
    public void claim() {
        System.out.println("Congratulations, you have won the Bruiser Award!");
    }
}
