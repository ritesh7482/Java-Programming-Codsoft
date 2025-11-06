import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        String again;

        System.out.println("=======================================");
        System.out.println("     🎯  NUMBER GUESSING GAME  🎯");
        System.out.println("=======================================");
        System.out.println("Guess a number between 1 and 100.");
        System.out.println("You have 7 attempts per round.\n");

        do {
            int target = random.nextInt(100) + 1;  // 1–100
            int attempts = 0;
            int maxAttempts = 7;
            boolean correct = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (" + (attempts + 1) + "/" + maxAttempts + "): ");
                int guess;

                try {
                    guess = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Please enter a valid number!");
                    continue;
                }

                attempts++;

                if (guess == target) {
                    System.out.println("🎉 Congratulations! You guessed it right in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1) * 10;
                    correct = true;
                    break;
                } else if (guess < target) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }
            }

            if (!correct) {
                System.out.println("❌ Out of attempts! The correct number was " + target + ".");
            }

            System.out.println("Your current score: " + score);
            System.out.print("\nDo you want to play another round? (yes/no): ");
            again = input.nextLine().trim().toLowerCase();
            System.out.println();

        } while (again.equals("yes"));

        System.out.println("🏁 Game Over! Final Score: " + score);
        System.out.println("Thank you for playing!");
        input.close();
    }
}
