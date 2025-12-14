import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 7;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts per round.\n");

        boolean playAgain = true;

        while (playAgain) {
            roundsPlayed++;
            int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            boolean guessedCorrectly = false;

            System.out.println("Round " + roundsPlayed + " starts!");

            for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");

                int guess;
                // Validate input
                while (true) {
                    if (scanner.hasNextInt()) {
                        guess = scanner.nextInt();
                        if (guess >= LOWER_BOUND && guess <= UPPER_BOUND) {
                            break;
                        } else {
                            System.out.print("Please enter a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ": ");
                        }
                    } else {
                        System.out.print("Invalid input. Please enter an integer: ");
                        scanner.next(); // discard invalid input
                    }
                }

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + targetNumber + ".");
            }

            System.out.println("Score: " + roundsWon + " wins out of " + roundsPlayed + " rounds.");

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume newline left-over
            String response = scanner.nextLine().trim().toLowerCase();

            playAgain = response.equals("yes") || response.equals("y");
            System.out.println();
        }

        System.out.println("Thank you for playing! Final score: " + roundsWon + " wins out of " + roundsPlayed + " rounds.");
        scanner.close();
    }
}
