package game;

import achievement.Achievement;
import achievement.AchievementSetFactory;
import statistic.StatSet;
import statistic.Statistic;

import java.util.ArrayList;
import java.util.HashSet;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static statistic.constants.StatAttribute.LIFETIME;

public class Player {
    private final String name;
    private final StatSet lifetimeStats;
    private StatSet lastGameStats;
    private final HashSet<Achievement> possibleAwards;
    private final HashSet<Achievement> awardsEarned;

    public Player(String name, StatSet statSet, HashSet<Achievement> achievementSet) {
        this.name = name;
        this.lifetimeStats = statSet;
        this.lastGameStats = null;
        this.possibleAwards = achievementSet;
        this.awardsEarned = newHashSet();
    }

    public static Player createPlayer(String name) {
        final AchievementSetFactory achievementSetFactory = new AchievementSetFactory();
        return new Player(name, new StatSet(LIFETIME), achievementSetFactory.createFullAchievementSet());
    }

    public void updateStats(StatSet gameStats) {
        lastGameStats = gameStats;
        for (Statistic stat : gameStats) {
            lifetimeStats.update(stat);
        }
    }

    public void evaluateAchievements() throws Exception {
        if (lastGameStats == null) {
            throw new Exception("Error: you haven't played a game yet!");
        }

        final ArrayList<Achievement> newlyEarnedAwards = newArrayList();

        for (Achievement award : possibleAwards) {
            if (award.evaluate(lifetimeStats)) {
                awardsEarned.add(award);
                newlyEarnedAwards.add(award);
            }
            if (award.evaluate(lastGameStats)) {
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
