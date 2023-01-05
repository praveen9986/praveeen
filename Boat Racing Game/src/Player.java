import java.util.Scanner;
import java.util.Random;

public class Player {
    private String name;
    private int score = 0;
    private int location = 0;
    private Scanner input = new Scanner(System.in);

    // Constructor
    public Player() {
        name = "";
    }

    public Player(String name) {
        this.name = name;
    }

    // Setter and Getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void promptName(int num) {
        System.out.printf("Please enter Player %d's name: ", num);
        name = input.nextLine();
        while (name.equals("") || name.length() > 18) {
            if (name.equals("")) {
                System.out.println("Please enter a valid name!");
            } else if (name.length() > 18) {
                System.out.println("Name cannot be more than 18 characters!");
            }
            System.out.printf("Please enter Player %d's name: ", num);
            name = input.nextLine();
        }
    }

    public int throwDice() {
        Random randomNum = new Random();
        System.out.printf("> %s, press ENTER to throw dice", name);
        input.nextLine();
        int dice = (1 + randomNum.nextInt(6));
        System.out.println("- You rolled a " + dice);
        return dice;
    }

    @Override
    public String toString() {
        return String.format("- You've moved to location %d\n", location);
    }

}
