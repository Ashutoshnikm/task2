package task2;



import java.util.Random;
import javax.swing.JOptionPane;



public class GuessTheNumber {
    public static void main(String[] args) {
        int score = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        while (playAgain) {
            int minRange = 1;
            int maxRange = 100;
            int targetNumber = generateRandomNumber(minRange, maxRange);
            int attempts = 0;
            boolean guessedCorrectly = false;

            JOptionPane.showMessageDialog(null, "Welcome to Guess the Number!");

            while (!guessedCorrectly) {
                String input = JOptionPane.showInputDialog("Enter your guess (between " 
                                                + minRange + " and " + maxRange + "):");
                
                int guess = Integer.parseInt(input);
                attempts++;

                if (guess == targetNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " 
                                                                     + attempts + " attempt(s).");
                    
                    score += (maxRange - minRange + 1) - attempts;
                    guessedCorrectly = true;
                    
                } else if (guess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                    
                    
                }

                if (attempts >= 10) {
                    JOptionPane.showMessageDialog(null, "Sorry, you have reached the maximum number of attempts. "
                    		                               + "  The number was " + targetNumber + ".");
                    
                    
                    break;
                }
            }

            totalAttempts += attempts;

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again"
            		                                      , JOptionPane.YES_NO_OPTION);
            
            
            playAgain = (choice == JOptionPane.YES_OPTION);
        }

        JOptionPane.showMessageDialog(null, "Game Over!");
        JOptionPane.showMessageDialog(null, "Total Score: " + score);
        JOptionPane.showMessageDialog(null, "Average Attempts per Game: " + (double) totalAttempts / 
        		                           (double) (score > 0 ? score : 1));
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}



