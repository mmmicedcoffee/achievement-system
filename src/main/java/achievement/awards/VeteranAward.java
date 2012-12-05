package achievement.awards;

import achievement.Achievement;
import statistic.StatisticSet;
import statistic.constants.StatisticKey;

import static statistic.constants.StatisticKey.LOSSES;
import static statistic.constants.StatisticKey.WINS;

public class VeteranAward implements Achievement {
    @Override
    public boolean evaluate(StatisticSet aStatisticSet) {
        return (aStatisticSet.getStatistic(WINS).getValue() + aStatisticSet.getStatistic(LOSSES).getValue()) >= 1000d;
    }

    @Override
    public void claim() {
        System.out.println("Congratulations, you have won the Veteran Award!");
    }
}
