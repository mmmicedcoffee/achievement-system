import game.Game;

import static game.Team.createTeam;

public class Main {
    private static final int TEAM_SIZE = 5;
    private static final String TEAM_A_NAME = "A";
    private static final String TEAM_B_NAME = "B";
    private static final int NUM_GAMES = 10;

    public static void main(String[] args) {
        // make a game
        Game game = new Game(createTeam(TEAM_A_NAME, TEAM_SIZE), createTeam(TEAM_B_NAME, TEAM_SIZE));
        // uncomment below to turn on verbose logging
        // game.setVerbose(true);

        // play a few games - should update stats
        try {
            for (int i = 0; i < NUM_GAMES; i++) {
                game.playGame();
            }
        } catch (Exception e) {
            System.out.println("Failed to play game.");
            e.printStackTrace();
        }
    }
}
