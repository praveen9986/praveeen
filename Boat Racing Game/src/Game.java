public class Game {
    public static void main(String[] args) {

        // Welcome to the Game
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║              Welcome to the Boat Racing Game!             ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        System.out.println("Instructions: ");
        System.out.println("> This is a two players game.\n");

        // Prompt for players' name
        BoatRace.getPlayer1().promptName(1);
        BoatRace.getPlayer2().promptName(2);

        System.out.println("\n> At the beginning, each player will be allocated with a boat.");
        System.out.println(
                "> During the game, both players will take turns to throw the dice to decide the number of steps to be moved forward.");
        System.out.println(
                "> The river can be visualized as a track with 100 tiles, filled with random number of Traps (T) and Currents (C) depending on the difficulty level.");

        System.out.println();

        // prompt for difficulty level and initialize river objects
        String difficultyLevel = BoatRace.promptDifficultyLevel();
        BoatRace.getRiver().setDifficultyLevel(difficultyLevel);

        System.out.println("\n> The river for your Boat Race is as printed below:");
        BoatRace.getRiver().printRiverList();
        System.out.println();
        System.out.println("> The track of this river should be read row by row, from left to right.");
        System.out.println("  - The starting position is at 0.");
        System.out.println("  - When the boat hits a trap, it needs to move backward x number of steps.");
        System.out.println("  - When the boat hits a current, it needs to move forward x number of steps.");
        System.out.println("  - The game ends when one of the boat reaches the end of the river.");
        System.out.println();

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║               Game Begins!               ║");
        System.out.println("╚══════════════════════════════════════════╝");
        
        BoatRace.startGame();

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║               Game Over!                 ║");
        System.out.println("╚══════════════════════════════════════════╝");

        System.out.printf("\n# Congratulations! %s won!\n", BoatRace.getWinner().getName());
        BoatRace.getWinner().setScore(BoatRace.getNumOfTurns());

        BoatRace.getFileHandler().updateList(BoatRace.getWinner(), Integer.parseInt(difficultyLevel));

        System.out.printf("# You won the game within %d moves\n", BoatRace.getNumOfTurns());

        BoatRace.getFileHandler().printPlayers(Integer.parseInt(difficultyLevel));
    }
}
