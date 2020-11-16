/** OOP3200. F2020. Main.java
 *	@author		Raje Singh, Angus Wai
 *	@studentIDs	100776793 & 100719558
 *	@version	2020.10
 *	@date		October 8, 2020
 */
package ca.durhamcollege;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Scanner
        Scanner keyboardInput = new Scanner(System.in);

        // Number of games played
        int gamesPlayed = 0;

        // Number of players per game
        int teamSize = 0;

        // Validate teamSize
        boolean teamFlag = false;
        while (!teamFlag)
        {
            try
            {
                System.out.print("Please enter the number of players: ");
                teamSize = keyboardInput.nextInt();
                teamFlag = true;
                keyboardInput.nextLine();
            }
            catch (InputMismatchException inputE)
            {
                System.out.println("Error: You must enter a valid integer number");
                keyboardInput.nextLine();
                teamFlag = false;
            }
        }

        // String holding the names of the players
        String[] players = new String[teamSize];

        for (int i = 0; i < teamSize; i++)
        {
            System.out.print("Please enter the name of Player #" + (i + 1) + ": ");
            players[i] = keyboardInput.nextLine();
        }

        // Validate gamesPlayed
        boolean gamesFlag = false;
        while (!gamesFlag)
        {
            try
            {
                System.out.print("Please enter the number of games played: ");
                gamesPlayed = keyboardInput.nextInt();
                keyboardInput.nextLine();
                gamesFlag = true;

            }
            catch (InputMismatchException inputE)
            {
                System.out.println("Error: You must enter a valid integer number.");
                keyboardInput.nextLine();
                gamesFlag = false;
            }
        }

        // Two-Dimensional Array
        int [][] scoreboard = new int[teamSize][gamesPlayed];

        // Populate Array with valid data
        for (int y= 0; y < gamesPlayed; y++)
        {
            for (int x = 0; x < teamSize; x++)
            {
                boolean isValidInput = false;

                do
                {
                    System.out.print("Please enter " + players[x] + "'s score for game #" + (y + 1) + ": ");

                    // Try Catch for InputMisMatchException
                    try
                    {
                        scoreboard[x][y] = keyboardInput.nextInt();
                        keyboardInput.nextLine();
                        isValidInput = true;

                        // Check Range of Entered Value
                        if ((scoreboard[x][y] <= 0) || (scoreboard[x][y] > 300))
                        {
                            System.out.println("Invalid input. Value between 0 and 300 needed. Please try again.");
                            keyboardInput.nextLine();
                            isValidInput = false;
                        }
                    }
                    catch (InputMismatchException inputMismatchException)
                    {
                        System.out.println("Invalid input. Numeric value needed. Please try again.");
                        keyboardInput.nextLine();
                        isValidInput = false;
                    }
                }
                while(!isValidInput);

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
