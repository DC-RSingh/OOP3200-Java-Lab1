/** OOP3200. F2020. Main.java
 *	@author		Raje Singh, Angus Wai
 *	@studentIDs	100776793 & 100719558
 *	@version	2020.10
 *	@date		October 8, 2020
 */
package ca.durhamcollege;

import java.util.Scanner;

public class Main
{
    /**
     * Checks if a scanner's next token is an integer and returns it if the check was successful.
     *
     * Outputs error messages to System.out if invalid input was entered (out of range or not an int).
     *
     * @param input An object of type Scanner
     * @param range The maximum value the integer may have (0 to range)
     * @return 0 if no integer, -1 the integer was out range, or the integer if it was found to be within the range
     */
    private static int ValidatePositiveInteger(Scanner input, int range)
    {
        int validInt = 0;

        if (input.hasNextInt())
        {
            validInt = input.nextInt();

            if (validInt < 0 || validInt > range)
            {
                System.out.println("Invalid input. Value between 0 and " + range + " needed. " +
                        "Please try again.");
                validInt = -1;
            }
        }
        else
        {
            System.out.println("Error: You must enter a valid integer number");
        }
        input.nextLine();

        return validInt;
    }

    public static void main(String[] args)
    {
        // Scanner
        Scanner keyboardInput = new Scanner(System.in);

        // Number of games played
        int gamesPlayed = 0;

        // Number of players per game
        int teamSize = 0;

        // Validate teamSize
        while (teamSize <= 0)
        {
            System.out.print("Please enter the number of players (cannot be zero): ");
            teamSize = ValidatePositiveInteger(keyboardInput, 8);
        }

        // String holding the names of the players
        String[] players = new String[teamSize];

        // Prompt user to enter the names of the users
        for (int i = 0; i < teamSize; i++)
        {
            System.out.print("Please enter the name of Player #" + (i + 1) + ": ");
            players[i] = keyboardInput.nextLine();
        }

        // Validate gamesPlayed
        while (gamesPlayed <= 0)
        {
            System.out.print("Please enter the number of games played (cannot be zero): ");
            gamesPlayed = ValidatePositiveInteger(keyboardInput, Integer.MAX_VALUE);
        }

        // Two-Dimensional Array
        int [][] scoreboard = new int[teamSize][gamesPlayed];

        // Populate Array with valid data
        for (int y= 0; y < gamesPlayed; y++)
        {
            for (int x = 0; x < teamSize; x++)
            {
                do
                {
                    System.out.print("Please enter " + players[x] + "'s score for game #" + (y + 1) + ": ");
                    scoreboard[x][y] = ValidatePositiveInteger(keyboardInput, 300);
                }
                while(scoreboard[x][y] < 0);
            }
        }

        // Output Scoreboard Information
        for (int x = 0; x < teamSize; x++)
        {
            float average = 0f;
            System.out.println("Score details for " + players[x] + ":");
            for (int y= 0; y < gamesPlayed; y++)
            {
                System.out.println("Game #" + (y + 1) + ": " + scoreboard[x][y]);
                average += (float)scoreboard[x][y];
            }
            average /= (float)gamesPlayed;
            System.out.println("Average for " + players[x] + ": " + average + "\n");
        }
    }
}