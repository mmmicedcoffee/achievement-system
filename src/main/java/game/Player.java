package game;

import achievement.Achievement;
import achievement.AchievementSetFactory;
import statistic.Statistic;
import statistic.StatisticSet;

import java.util.ArrayList;
import java.util.HashSet;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

public class Player {
    private final String name;
    private final StatisticSet lifetimeStats;
    private final HashSet<Achievement> possibleAwards;
    private final HashSet<Achievement> awardsEarned;

    public Player(String name, StatisticSet statisticSet, HashSet<Achievement> achievementSet) {
        this.name = name;
        this.lifetimeStats = statisticSet;
        this.possibleAwards = achievementSet;
        this.awardsEarned = newHashSet();
    }

    public static Player createPlayer(String name) {
        final AchievementSetFactory achievementSetFactory = new AchievementSetFactory();
        return new Player(name, new StatisticSet(), achievementSetFactory.createFullAchievementSet());
    }

    public void updateStats(StatisticSet gameStats) {
        for (Statistic stat : gameStats) {
            lifetimeStats.update(stat);
        }
    }

    public void evaluateAchievements() {
        final ArrayList<Achievement> newlyEarnedAwards = newArrayList();

        for (Achievement award : possibleAwards) {
            if (award.evaluate(lifetimeStats)) {
                awardsEarned.add(award);
                newlyEarnedAwards.add(award);
            }
        }

        for (Achievement award : newlyEarnedAwards) {
            possibleAwards.remove(award);
            System.out.print(name + ": ");
            award.claim();
        }
    }

    public String getName() {
        return name;
    }
}
