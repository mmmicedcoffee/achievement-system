import game.Game;

import static game.Team.createTeam;

public class Main {
    private static final int TEAM_SIZE = 5;
    private static final String TEAM_A_NAME = "A";
    private static final String TEAM_B_NAME = "B";

    public static void main(String[] args) {
        // make a game
        Game game = new Game(createTeam(TEAM_A_NAME, TEAM_SIZE), createTeam(TEAM_B_NAME, TEAM_SIZE));
        // play a game - should update stats
        game.playGame();
    }
}
