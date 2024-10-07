package project_game;

import java.util.Scanner;
import java.util.Random;

public class game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0; // To track the total score across 5 rounds
        int maxRounds = 5;  // Number of rounds
        int maxAttempts = 5; // Number of attempts per round

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You need to guess a number between 1 and 100.");
        System.out.println("You have " + maxRounds + " rounds and " + maxAttempts + " attempts per round.");
        System.out.println("Let's start!");

        // Loop through each round
        for (int round = 1; round <= maxRounds; round++) {
            int targetNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int roundScore = 0; // Reset round score

            System.out.println("\nRound " + round + " starts!");
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    roundScore = (maxAttempts - attempt + 1) * 10; // Score based on remaining attempts
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("The number is greater than " + userGuess);
                } else {
                    System.out.println("The number is smaller than " + userGuess);
                }
            }
            // If round score is 0, user failed all attempts
            if (roundScore == 0) {
                System.out.println("Sorry! You've used all attempts. The correct number was " + targetNumber);
            }

            // Add round score to total score
            totalScore += roundScore;
            System.out.println("Round " + round + " score: " + roundScore);
            System.out.println("Total score so far: " + totalScore);
        }

        // Final score after all rounds
        System.out.println("\nGame over! Your total score after " + maxRounds + " rounds is: " + totalScore);
        scanner.close();
    }
}
