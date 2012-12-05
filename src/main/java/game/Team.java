package game;

import statistic.StatisticSet;

import static game.Player.createPlayer;

public class Team {
    private final String name;
    private final Player[] players;

    public Team(String name, Player[] players) {
        this.name = name;
        this.players = players;
    }

    public static Team createTeam(String name, int size) {
        final Player[] somePlayers = new Player[size];
        for (int i = 0; i < size; i++) {
            somePlayers[i] = createPlayer("P" + String.valueOf(i));
        }
        return new Team(name, somePlayers);
    }

    public void updateStatsForPlayer(int playerIndex, StatisticSet statistics) {
        players[playerIndex].updateStats(statistics);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return players.length;
    }

    public Player[] getPlayers() {
        return players;
    }
}
