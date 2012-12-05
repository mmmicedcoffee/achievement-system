package game;

import statistic.StatisticSet;
import statistic.StatisticSetFactory;

import java.util.Random;

import static statistic.constants.StatisticParameters.MIN_TIME_PLAYED;
import static statistic.constants.StatisticParameters.MAX_TIME_PLAYED;

public class Game {
    private final Team teamA;
    private final Team teamB;
    private final int teamSize;

    public Game(Team teamA, Team teamB) {
        assert(teamA.getSize() == teamB.getSize());
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamSize = teamA.getSize();
    }

    public void playGame() {
        final Random random = new Random();
        final StatisticSetFactory factory = new StatisticSetFactory();
        // generate a winner
        final boolean winnerA = random.nextBoolean();

        // generate length of game
        final int gameLength = random.nextInt(MAX_TIME_PLAYED);

        // TODO: in need of refactoring!
        if (winnerA) {
            for (int i = 0; i < teamSize; i++) {
                final StatisticSet statistics = factory.generateStats(true, gameLength);
                System.out.println("TEAM " + teamA.getName() + " " + teamA.getPlayers()[i].getName());
                System.out.println(statistics.toString());
                teamA.updateStatsForPlayer(i, statistics);
            }

            for (int i = 0; i < teamSize; i++) {
                final StatisticSet statistics = factory.generateStats(false, gameLength);
                System.out.println("TEAM " + teamB.getName() + " " + teamB.getPlayers()[i].getName());
                System.out.println(statistics.toString());
                teamB.updateStatsForPlayer(i, statistics);
            }
        } else {
            for (int i = 0; i < teamSize; i++) {
                final StatisticSet statistics = factory.generateStats(true, gameLength);
                System.out.println("TEAM " + teamB.getName() + " " + teamB.getPlayers()[i].getName());
                System.out.println(statistics.toString());
                teamB.updateStatsForPlayer(i, statistics);
            }

            for (int i = 0; i < teamSize; i++) {
                final StatisticSet statistics = factory.generateStats(false, gameLength);
                System.out.println("TEAM " + teamA.getName() + " " + teamA.getPlayers()[i].getName());
                System.out.println(statistics.toString());
                teamA.updateStatsForPlayer(i, statistics);
            }
        }

        // evaluate achievements for each player
        System.out.println(teamA.getName() + " Achievements");
        System.out.println("-------");
        for (Player p : teamA.getPlayers()) {
            p.evaluateAchievements();
        }

        System.out.println();

        System.out.println(teamB.getName() + " Achievements");
        System.out.println("-------");
        for (Player p : teamB.getPlayers()) {
            p.evaluateAchievements();
        }
    }
}
