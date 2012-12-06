package game;

import statistic.StatSet;
import statistic.StatSetFactory;

import java.util.Random;

import static statistic.constants.StatParameters.MAX_TIME_PLAYED;

public class Game {
    private final Team teamA;
    private final Team teamB;
    private final int teamSize;
    private boolean verbose = false;

    public Game(Team teamA, Team teamB) {
        assert (teamA.getSize() == teamB.getSize());
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamSize = teamA.getSize();
    }

    public void playGame() throws Exception {
        System.out.println("\nNEW GAME");
        System.out.println("--------");
        final Random random = new Random();
        final StatSetFactory factory = new StatSetFactory();
        // generate a winner
        final boolean winnerA = random.nextBoolean();
        Team winner;
        Team loser;
        if (winnerA) {
            winner = teamA;
            loser = teamB;
        } else {
            winner = teamB;
            loser = teamA;
        }

        // generate length of game
        final int gameLength = random.nextInt(MAX_TIME_PLAYED);

        // update winner stats
        for (int i = 0; i < teamSize; i++) {
            final StatSet statistics = factory.generateRandomGameStats(true, gameLength);
            if (verbose) {
                System.out.println("TEAM " + winner.getName() + " " + winner.getPlayers()[i].getName());
                System.out.println(statistics.toString());
            }
            winner.updateStatsForPlayer(i, statistics);
        }

        // update loser stats
        for (int i = 0; i < teamSize; i++) {
            final StatSet statistics = factory.generateRandomGameStats(false, gameLength);
            if (verbose) {
                System.out.println("TEAM " + loser.getName() + " " + loser.getPlayers()[i].getName());
                System.out.println(statistics.toString());
            }
            loser.updateStatsForPlayer(i, statistics);
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

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }
}
