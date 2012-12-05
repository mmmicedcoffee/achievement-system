package achievement.awards;

import achievement.Achievement;
import statistic.StatisticSet;
import statistic.constants.StatisticKey;

import static statistic.constants.StatisticKey.WINS;

public class BigWinnerAward implements Achievement {
    @Override
    public boolean evaluate(StatisticSet aStatisticSet) {
        return aStatisticSet.getStatistic(WINS).getValue() >= 200d;
    }

    @Override
    public void claim() {
        System.out.println("Congratulations, you have won the Big Winner Award!");
    }
}
