import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        do{
            System.out.println("Enter the lower limit: ");
            int lower = sc.nextInt();

            System.out.println("Enter the upper limit: ");
            int upper = sc.nextInt();

            System.out.println("Enter the number of attempts allowed:");
            int attempts = sc.nextInt();

            if (lower >= upper){
                System.out.println("Invalid limits. Please try again.");
                continue;
            }
            int randomNum = random.nextInt(upper - lower + 1) + lower;
            int guess=0;
            int count = 0;

            System.out.println("Guess the number between " + lower + " and " + upper + ": ");

            while (count < attempts){
                System.out.print("Enter your guess: ");
                try{
                    guess = sc.nextInt();
                    count++;
                    if (guess < lower || guess > upper){
                        System.out.print("Please enter a number within the limits.");
                    }
                    else if (guess == randomNum){
                        System.out.println("Congratulations! You guessed the number in " + count + " attempts.");
                        break;
                    }
                    else if (guess < randomNum){
                        System.out.println("Try a higher number.");
                    }
                    else{
                        System.out.println("Try a lower number.");  
                    }
                } catch (Exception e){
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next();
                }
            }
            if (guess != randomNum){
                System.out.println("You have exhausted all your attempts. The number was " + randomNum + ".");
            }
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = sc.next().equalsIgnoreCase("yes");
        }
        while (playAgain);
        System.out.println("Thank you for playing the Number Guessing Game!");
        sc.close();
    }
}